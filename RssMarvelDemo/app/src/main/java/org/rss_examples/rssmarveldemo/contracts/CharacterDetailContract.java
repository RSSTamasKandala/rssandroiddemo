package org.rss_examples.rssmarveldemo.contracts;


import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface CharacterDetailContract {
    public interface ICharacterDetailView extends IMvlView {
        void showCharacterInfo(CharacterDto value);
        void setupComicsList(ComicsDto comics);
        void onArrowClick();
        void onBackClick();
        String getPicUrl();
    }

    public interface ICharacterDetailViewModel extends IMvlViewModel {
        void getCharacterData(String string);
        void getCharactersComicsList(int id);
        String getPicUrl();
        void onArrowClick(View view);
        void onBackClick(View view);
    }
}
