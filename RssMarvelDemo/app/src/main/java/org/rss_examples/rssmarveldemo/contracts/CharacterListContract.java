package org.rss_examples.rssmarveldemo.contracts;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

import java.util.List;

public interface CharacterListContract {

    public interface ICharacterListView extends IMvlView{
        void showList(List<IMvlItemView> list);
        void addList(List<IMvlItemView> list);
    }

    public interface IVmCharacterList extends IMvlViewModel{
        void getCharacterList(int skip);
        void unSubscribe();
    }
}
