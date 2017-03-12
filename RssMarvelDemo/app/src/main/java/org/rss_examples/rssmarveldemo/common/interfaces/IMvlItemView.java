package org.rss_examples.rssmarveldemo.common.interfaces;


import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;

public interface IMvlItemView<V extends ViewDataBinding> {

    int getLayoutId();

    void onBindView(RecycleBindingVHolder<V> holder);
}
