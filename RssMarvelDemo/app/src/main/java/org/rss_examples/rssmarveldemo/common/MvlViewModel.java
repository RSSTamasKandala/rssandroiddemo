package org.rss_examples.rssmarveldemo.common;

import android.databinding.BaseObservable;


public class MvlViewModel<V extends IMvlView> extends BaseObservable {

    protected V mvlView;

    public void setView(V view) {
        mvlView = view;
    }
}
