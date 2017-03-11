package org.rss_examples.rssmarveldemo;

import android.content.Context;

import org.rss_examples.rssmarveldemo.data.IErrorListener;


public class MvlErrorListener implements IErrorListener {

    private static MvlErrorListener instance;

    private final Context context;

    public static synchronized MvlErrorListener getInstance(Context context) {
        if (instance == null) {
            instance = new MvlErrorListener(context);
        }
        return instance;
    }

    private MvlErrorListener(Context context) {
        this.context = context;
    }

    private static final int MVL_EXCEPTION_CODE = -123456789;


    @Override
    public void onError(String message) {

    }

    @Override
    public String getRequestFailedMessage(int code) {
        return context.getString(R.string.request_failed_msg);
    }

    @Override
    public String getMarvelApiErrorMessage(int code) {
        return context.getString(R.string.marvel_api_error_msg);
    }

    @Override
    public int getMarvelApiExceptionCode() {
        return MVL_EXCEPTION_CODE;
    }
}
