package org.rss_examples.rssmarveldemo.common.utils;

public class RestError extends Exception {

    public RestError(int errorCode) {
        super("" + errorCode);
    }
}
