package org.rss_examples.rssmarveldemo.contracts;


import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.MarvelCollection;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

import java.util.List;

public interface ComicDetailContract {

    public interface IDetailView extends IMvlView {
        void showComicInfo(ComicDto value);
        void setupViewPager(List<MarvelCollection> collections);
    }

    public interface IDetailViewModel extends IMvlViewModel {
        void getComicData(String string);
    }

}
