package org.rss_examples.rssmarveldemo.contracts;


import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface ComicItemContract {
    public interface IComictemView<V extends ViewDataBinding> extends IMvlItemView<V> {

    }

    public interface IVmComicItem extends IMvlViewModel {
        String getPicUrl();
        String getName();
    }
}
