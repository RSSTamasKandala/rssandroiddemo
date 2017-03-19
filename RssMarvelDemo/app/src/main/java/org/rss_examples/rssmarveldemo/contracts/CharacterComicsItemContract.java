package org.rss_examples.rssmarveldemo.contracts;

import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface CharacterComicsItemContract {

    public interface ICharacterComicsItemView<V extends ViewDataBinding> extends IMvlItemView<V> {
    }

    public interface IVmCharacterComicsItem extends IMvlViewModel {
        String getPicUrl();
    }
}
