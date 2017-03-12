package org.rss_examples.rssmarveldemo.common.superclasses;

import android.databinding.BaseObservable;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;


public class MvlViewModel<V extends IMvlView> extends BaseObservable {

    protected V mvlView;

    public void setView(V view) {
        mvlView = view;
    }
}
