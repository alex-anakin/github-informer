package org.anakin.engine;

public final class GithubException extends RuntimeException {
    public GithubException(final String message, final Exception e) {
        super(message, e);
    }
}
