package org.rss_examples.rssmarveldemo.common.interfaces;

import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;

public interface IItemView<B extends ViewDataBinding> {

    int getLayoutId();
    void onBind(RecycleBindingVHolder<B> holder);
}
