package org.rss_examples.rssmarveldemo.common.superclasses;

import android.databinding.BaseObservable;
import android.view.View;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;

public class MvlItemViewModel<V extends IMvlItemView> extends BaseObservable {

    protected V mvlItemView;

    public void setView(V view) {
        mvlItemView = view;
    }

    public void onItemClick(View view) {

    }
}
