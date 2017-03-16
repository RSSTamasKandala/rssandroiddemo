package org.rss_examples.rssmarveldemo.view.comiclist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.ComicItemContract;
import org.rss_examples.rssmarveldemo.databinding.ComicItemBinding;
import org.rss_examples.rssmarveldemo.view.MvlNavigator;
import org.rss_examples.rssmarveldemo.viewmodels.comiclist.VmComicItem;

public class ComicItemView implements ComicItemContract.IComictemView<ComicItemBinding> {

    private final ComicDto comic;
    private final VmComicItem vmComicItem;

    private ImageView imageView;
    private TextView textView;

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
        imageView = holder.getViewDataBinding().comicItemImage;
        textView = holder.getViewDataBinding().comicItemTitle;
    }

    @Override
    public void onItemClick(View view) {
        MvlNavigator.getInstance().startComicDetail(comic.getId(), imageView, textView);
    }
}
