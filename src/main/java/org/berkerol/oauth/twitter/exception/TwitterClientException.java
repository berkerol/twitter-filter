package org.berkerol.oauth.twitter.exception;

public class TwitterClientException extends Exception {

    public TwitterClientException() {
        super();
    }

    public TwitterClientException(final String message) {
        super(message);
    }

    public TwitterClientException(final String message, final Throwable t) {
        super(message, t);
    }

    public TwitterClientException(final Throwable t) {
        super(t);
    }
}
