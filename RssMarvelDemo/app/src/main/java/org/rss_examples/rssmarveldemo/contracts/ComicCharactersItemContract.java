package org.rss_examples.rssmarveldemo.contracts;

import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface ComicCharactersItemContract {

    public interface IComicCharactersItemView<V extends ViewDataBinding> extends IMvlItemView<V> {

    }

    public interface IVmComicCharactersItem extends IMvlViewModel {
        String getPicUrl();
        String getName();
    }
}
