package org.rss_examples.rssmarveldemo.contracts;


import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

import java.util.List;

public interface ComicListContract {
    public interface IComicListView extends IMvlView {
        void showList(List<IMvlItemView> list);
        void addList(List<IMvlItemView> list);
    }

    public interface IVmComicList extends IMvlViewModel {
        void getComicList(int skip);
        void unSubscribe();
    }
}
