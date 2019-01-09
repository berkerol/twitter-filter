package org.berkerol.oauth.twitter;

import com.google.api.client.http.HttpRequestFactory;
import org.berkerol.oauth.twitter.exception.TwitterAuthenticationException;
import org.berkerol.oauth.twitter.exception.TwitterClientException;

import java.io.PrintStream;

/**
 * Main class of this program that gets an authorization, executes Twitter API requests and prints the result
 */
public class Main {

    /**
     * Output stream for printing the result
     */
    private static final PrintStream OUT = System.out;

    /**
     * Key token for OAuth requests
     */
    private static final String CONSUMER_KEY = "vp8qXAMoZzy6jowJdtouPLUUb";

    /**
     * Secret token for OAuth requests
     */
    private static final String CONSUMER_SECRET = "IMx3eIRfXXbRimoIz7cNpZCl0dr9dYEdRuDVTr2C4LdResXjN7";

    /**
     * Keyword for filtering the tweets
     */
    private static final String KEYWORD = "trump";

    /**
     * Max number of tweets to be retrieved
     */
    private static final int MAX_TWEET_COUNT = 100;

    /**
     * Max amount of time to be spent for retrieving the tweets (in milliseconds)
     */
    private static final int MAX_TIME_AMOUNT = 30000;

    public static void main(String[] args) throws TwitterAuthenticationException, TwitterClientException {

        TwitterAuthenticator authenticator = new TwitterAuthenticator(OUT, CONSUMER_KEY, CONSUMER_SECRET);

        HttpRequestFactory factory = authenticator.getAuthorizedHttpRequestFactory();

        TwitterClient client = new TwitterClient(OUT, KEYWORD, MAX_TWEET_COUNT, MAX_TIME_AMOUNT);

        client.processTweets(factory);
    }
}
