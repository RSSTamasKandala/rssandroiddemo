package org.rss_examples.rssmarveldemo.common;


import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.RecycleBindingVHolder;

public interface IMvlItemView<V extends ViewDataBinding> extends IMvlView {

    int getLayoutId();

    void onBindView(RecycleBindingVHolder<V> holder);
}
