package org.rss_examples.rssmarveldemo.common.view;

import android.databinding.adapters.ProgressBarBindingAdapter;
import android.view.View;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.databinding.ProgressItemBinding;

/**
 * Created by Rss_Kandala on 2017. 03. 17..
 */

public class ProgressItemView implements IMvlItemView<ProgressItemBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.progress_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<ProgressItemBinding> holder) {

    }

    @Override
    public void onItemClick(View view) {

    }
}
