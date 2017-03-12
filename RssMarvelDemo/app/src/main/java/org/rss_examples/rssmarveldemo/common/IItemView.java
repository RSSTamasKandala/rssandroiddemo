package org.rss_examples.rssmarveldemo.common;

import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.RecycleBindingVHolder;

public interface IItemView<B extends ViewDataBinding> {

    int getLayoutId();
    void onBind(RecycleBindingVHolder<B> holder);
}
