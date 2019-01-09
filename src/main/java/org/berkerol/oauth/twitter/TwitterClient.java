package org.berkerol.oauth.twitter;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.berkerol.oauth.twitter.exception.TwitterClientException;
import org.berkerol.oauth.twitter.response.Tweet;
import org.berkerol.oauth.twitter.response.User;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Executes Twitter API requests, parses the response, sorts and groups the result and prints it
 */
public class TwitterClient {

    /**
     * Output stream for printing the tweets
     */
    private final PrintStream out;

    /**
     * Keyword for filtering the tweets
     */
    private final String keyword;

    /**
     * Max number of tweets to be retrieved
     */
    private final int maxTweetCount;

    /**
     * Max amount of time to be spent for retrieving the tweets (in milliseconds)
     */
    private final int maxTimeAmount;

    /**
     * Endpoint for Twitter filter API
     */
    private static final String FILTER_URL = "https://stream.twitter.com/1.1/statuses/filter.json";

    public TwitterClient(final PrintStream out, final String keyword, final int maxTweetCount, final int maxTimeAmount) {
        this.out = out;
        this.keyword = keyword;
        this.maxTweetCount = maxTweetCount;
        this.maxTimeAmount = maxTimeAmount;
    }

    /**
     * Prints tweets that are filtered according to the keyword, grouped by their users and sorted according to their creation dates
     *
     * @param factory factory to be used for executing filter API requests
     * @throws TwitterClientException if something goes wrong while building and executing the request and parsing the response
     */
    public void processTweets(HttpRequestFactory factory) throws TwitterClientException {
        List<Tweet> tweetList = new ArrayList<>();
        try {
            //Build a HTTP request that filters tweets according to the given keyword
            HttpRequest request = factory.buildGetRequest(new GenericUrl(FILTER_URL + "?track="
                    + URLEncoder.encode(keyword, StandardCharsets.UTF_8.name())));

            //Execute this request then build a BufferedReader object to read the stream of this response
            HttpResponse response = request.execute();
            InputStream responseStream = response.getContent();
            InputStreamReader responseStreamReader = new InputStreamReader(responseStream);
            BufferedReader responseReader = new BufferedReader(responseStreamReader);

            //Build a Gson object to parse the JSON response by using the date time format of Twitter API
            Gson gson = new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss Z yyyy").create();

            String tweetInput = responseReader.readLine();

            //Save the start time to check whether 30 seconds are passed
            long startTime = System.currentTimeMillis();

            /*
             * Process the response for 30 seconds or up to 100 tweets, whichever comes first
             * then convert JSON response to an object and add it to the list
             */
            while (tweetInput != null && tweetList.size() < maxTweetCount
                    && (System.currentTimeMillis() - startTime) < maxTimeAmount) {
                try {
                    tweetList.add(gson.fromJson(tweetInput, Tweet.class));
                } catch (JsonSyntaxException e) {
                    System.err.println("Unable to parse response: " + tweetInput + "\nError message: " + e.getMessage());
                }
                tweetInput = responseReader.readLine();
            }

            //Close reader and stream objects and disconnect from the response
            responseReader.close();
            responseStreamReader.close();
            responseStream.close();
            response.disconnect();

        } catch (IOException e) {
            throw new TwitterClientException("Unable to handle Filter request: " + e.getMessage(), e);
        }

        /*
         * First sort tweets chronologically by creation date of their users (ascending)
         * then sort tweets chronologically by creation date of tweets (ascending)
         * then group tweets by users to a LinkedHashMap to preserve the ordering
         */
        Map<User, List<Tweet>> tweetMap = tweetList
                .stream()
                .sorted(Comparator
                        .comparing((Tweet t) -> t.getUser().getCreationDate())
                        .thenComparing(Tweet::getCreationDate))
                .collect(Collectors.groupingBy(Tweet::getUser, LinkedHashMap::new, Collectors.toList()));

        /*
         * Print tweets grouped by users such that for each group
         * First print the information of user
         * then print the information of each tweet of that user
         */
        for (Map.Entry<User, List<Tweet>> entry : tweetMap.entrySet()) {
            User user = entry.getKey();
            out.println("\n\nUser");
            out.println("\nID: " + user.getId());
            out.println("Creation Date: " + user.getCreationDate());
            out.println("Screen Name: " + user.getScreenName());
            out.println("\nTweets by this user");
            for (Tweet tweet : entry.getValue()) {
                out.println("\n\tID: " + tweet.getId());
                out.println("\tCreation Date: " + tweet.getCreationDate());
                out.println("\tText: " + tweet.getText());
            }
        }
    }
}
