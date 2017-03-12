package org.rss_examples.rssmarveldemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class RecycleBindingVHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

    protected V itemView;

    public RecycleBindingVHolder(V itemView) {
        super(itemView.getRoot());
        this.itemView=itemView;

    }

    public V getViewDataBinding(){
        return  itemView;
    }

}