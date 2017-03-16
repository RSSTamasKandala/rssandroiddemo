package org.rss_examples.rssmarveldemo.contracts;


import android.view.View;

import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface ComicDetailContract {

    public interface IComicDetailView extends IMvlView {
        void showComicInfo(ComicDto value);
        void showComicsCharactersInfo(CharactersDto value);
        void onBackClick();
        void onMoreClick();
        void onArrowClick();
    }

    public interface IDetailViewModel extends IMvlViewModel {
        void getComicData(String string);
        void getComicsCharactersData(int id);
        void onBackClick(View view);
        void onMoreClick(View view);
        void onArrowClick(View view);
    }

}
