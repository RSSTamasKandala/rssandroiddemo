package org.rss_examples.rssmarveldemo.view.comiclist;

import android.view.View;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.ComicItemContract;
import org.rss_examples.rssmarveldemo.databinding.ComicItemBinding;
import org.rss_examples.rssmarveldemo.view.MvlNavigator;
import org.rss_examples.rssmarveldemo.viewmodels.comiclist.VmComicItem;

public class ComicItemView implements ComicItemContract.IComictemView<ComicItemBinding> {


    private final ComicDto comic;
    private VmComicItem vmComicItem;

    public ComicItemView(ComicDto comicDto) {
        this.comic=comicDto;
        this.vmComicItem = new VmComicItem(comicDto);
    }

    @Override
    public int getLayoutId() {
        return R.layout.comic_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<ComicItemBinding> holder) {
        vmComicItem.setView(this);
        holder.getViewDataBinding().setComicItem(vmComicItem);
    }

    @Override
    public void onItemClick(View view) {
        MvlNavigator.getInstance().startComicDetail(view.getContext(),comic);
    }
}
