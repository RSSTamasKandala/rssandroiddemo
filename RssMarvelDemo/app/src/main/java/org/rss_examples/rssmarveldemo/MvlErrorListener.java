package org.rss_examples.rssmarveldemo;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.rss_examples.rssmarveldemo.data.IErrorListener;


@EBean(scope = EBean.Scope.Singleton)
public class MvlErrorListener implements IErrorListener {

    @RootContext
    Context context;

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
