package org.rss_examples.rssmarveldemo.view.comiclist;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.databinding.ComicItemBinding;
import org.rss_examples.rssmarveldemo.viewmodels.comiclist.VmComicItem;

public class ComicItemView implements IMvlItemView<ComicItemBinding> {


    private VmComicItem vmComicItem;

    public ComicItemView(ComicDto comicDto) {
        this.vmComicItem= new VmComicItem(comicDto);
    }

    @Override
    public int getLayoutId() {
        return R.layout.comic_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<ComicItemBinding> holder) {
        holder.getViewDataBinding().setComicItem(vmComicItem);
    }
}
