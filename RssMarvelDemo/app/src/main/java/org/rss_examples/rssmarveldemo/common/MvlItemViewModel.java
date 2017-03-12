package org.rss_examples.rssmarveldemo.common;

import android.databinding.BaseObservable;

public class MvlItemViewModel<V extends IMvlItemView> extends BaseObservable {

    protected V mvlItemView;

    public void setView(V view) {
        mvlItemView = view;
    }
}
