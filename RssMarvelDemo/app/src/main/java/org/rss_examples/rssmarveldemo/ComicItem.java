package org.rss_examples.rssmarveldemo;

import org.rss_examples.rssmarveldemo.common.IMvlItemView;
import org.rss_examples.rssmarveldemo.databinding.ComicItemBinding;

public class ComicItem implements IMvlItemView<ComicItemBinding> {

    private VmComicItem vm;

    public VmComicItem getVm() {
        return vm;
    }

    public ComicItem(VmComicItem vm) {
        this.vm = vm;
    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void bindUI() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.comic_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<ComicItemBinding> holder) {
        holder.getViewDataBinding().setComicItem(vm);
    }
}
