package org.rss_examples.rssmarveldemo.utils;

public class RestError extends Exception {

    public RestError(Throwable throwable) {
        super(throwable);
    }

    public RestError(String detailMessage) {
        super(detailMessage);
    }

    public RestError(int errorCode) {
        super("" + errorCode);
    }
}
