package org.berkerol.oauth.twitter;

import com.google.api.client.auth.oauth.*;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.berkerol.oauth.twitter.exception.TwitterAuthenticationException;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Creates a factory that gives access to execute Twitter API requests by building OAuth requests
 */
public class TwitterAuthenticator {

    /**
     * Output stream for printing process information
     */
    private final PrintStream out;

    /**
     * Key token for OAuth requests
     */
    private final String consumerKey;

    /**
     * Secret token for OAuth requests
     */
    private final String consumerSecret;

    /**
     * Gives access to execute Twitter API requests
     */
    private HttpRequestFactory factory;

    /**
     * Used for OAuth requests and produces factory
     */
    private static final HttpTransport TRANSPORT = new NetHttpTransport();

    /**
     * Endpoint for Twitter OAuth authorization
     */
    private static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize";

    /**
     * Endpoint for Twitter OAuth token access
     */
    private static final String ACCESS_TOKEN_URL = "https://api.twitter.com/oauth/access_token";

    /**
     * Endpoint for Twitter OAuth token request
     */
    private static final String REQUEST_TOKEN_URL = "https://api.twitter.com/oauth/request_token";

    public TwitterAuthenticator(final PrintStream out, final String consumerKey, final String consumerSecret) {
        this.out = out;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    /**
     * Creates a factory from given OAuth tokens by executing OAuth requests
     *
     * @return factory to execute Twitter API requests
     * @throws TwitterAuthenticationException if something goes wrong during OAuth requests
     */
    public synchronized HttpRequestFactory getAuthorizedHttpRequestFactory() throws TwitterAuthenticationException {
        if (factory != null) {
            return factory;
        }

        OAuthHmacSigner signer = new OAuthHmacSigner();

        signer.clientSharedSecret = consumerSecret;

        OAuthGetTemporaryToken requestToken = new OAuthGetTemporaryToken(REQUEST_TOKEN_URL);
        requestToken.consumerKey = consumerKey;
        requestToken.transport = TRANSPORT;
        requestToken.signer = signer;

        OAuthCredentialsResponse requestTokenResponse;
        try {
            requestTokenResponse = requestToken.execute();
        } catch (IOException e) {
            throw new TwitterAuthenticationException("Unable to acquire a temporary token: " + e.getMessage(), e);
        }

        out.println("Acquired temporary token...\n");

        signer.tokenSharedSecret = requestTokenResponse.tokenSecret;

        OAuthAuthorizeTemporaryTokenUrl authorizeUrl = new OAuthAuthorizeTemporaryTokenUrl(AUTHORIZE_URL);
        authorizeUrl.temporaryToken = requestTokenResponse.token;

        String providedPin;
        try (Scanner scanner = new Scanner(System.in)) {
            out.println("Go to the following link in your browser:\n" + authorizeUrl.build());
            out.println("\nPlease enter the retrieved PIN:");
            providedPin = scanner.nextLine();
        }

        if (providedPin == null) {
            throw new TwitterAuthenticationException("Unable to read entered PIN");
        }

        OAuthGetAccessToken accessToken = new OAuthGetAccessToken(ACCESS_TOKEN_URL);
        accessToken.verifier = providedPin;
        accessToken.consumerKey = consumerSecret;
        accessToken.signer = signer;
        accessToken.transport = TRANSPORT;
        accessToken.temporaryToken = requestTokenResponse.token;

        OAuthCredentialsResponse accessTokenResponse;
        try {
            accessTokenResponse = accessToken.execute();
        } catch (IOException e) {
            throw new TwitterAuthenticationException("Unable to authorize access: " + e.getMessage(), e);
        }
        out.println("\nAuthorization was successful");

        signer.tokenSharedSecret = accessTokenResponse.tokenSecret;

        OAuthParameters parameters = new OAuthParameters();
        parameters.consumerKey = consumerKey;
        parameters.token = accessTokenResponse.token;
        parameters.signer = signer;

        factory = TRANSPORT.createRequestFactory(parameters);
        return factory;
    }
}
