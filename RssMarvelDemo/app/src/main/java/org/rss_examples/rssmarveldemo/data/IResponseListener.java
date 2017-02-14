package org.rss_examples.rssmarveldemo.data;

public interface IResponseListener<T extends Object> {

    void onResponse(T object);

}
