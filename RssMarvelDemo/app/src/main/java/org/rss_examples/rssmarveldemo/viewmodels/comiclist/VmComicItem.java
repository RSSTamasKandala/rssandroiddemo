package org.rss_examples.rssmarveldemo.viewmodels.comiclist;

import android.view.View;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlItemViewModel;
import org.rss_examples.rssmarveldemo.contracts.ComicItemContract;

public class VmComicItem extends MvlItemViewModel<ComicItemContract.IComictemView> implements ComicItemContract.IVmComicItem {


    private ComicDto data;

    public VmComicItem(ComicDto data) {
        this.data = data;
    }

    @Override
    public String getPicUrl() {
        return data.getThumbnail().getPath() + "." + data.getThumbnail().getExtension();
    }

    @Override
    public String getName() {
        return data.getTitle();
    }

    @Override
    public void onItemClick(View view) {
        super.onItemClick(view);
        this.mvlItemView.onItemClick(view);
    }
}
