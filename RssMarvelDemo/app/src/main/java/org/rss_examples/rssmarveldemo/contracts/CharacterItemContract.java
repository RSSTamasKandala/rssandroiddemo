package org.rss_examples.rssmarveldemo.contracts;


import android.databinding.ViewDataBinding;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface CharacterItemContract {

    public interface ICharacterItemView<V extends ViewDataBinding> extends IMvlItemView<V> {

    }

    public interface IVmCharacter extends IMvlViewModel {
        String getPicUrl();
        String getName();
    }
}
