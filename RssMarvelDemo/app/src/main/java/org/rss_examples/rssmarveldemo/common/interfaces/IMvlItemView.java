package org.rss_examples.rssmarveldemo.common.interfaces;


import android.databinding.ViewDataBinding;
import android.view.View;

import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;

public interface IMvlItemView<V extends ViewDataBinding> {

    int getLayoutId();

    void onBindView(RecycleBindingVHolder<V> holder);

    void onItemClick(View view);
}
