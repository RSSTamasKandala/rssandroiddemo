package org.rss_examples.rssmarveldemo.contracts;


import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface CharacterDetailContract {
    public interface ICharacterDetailView extends IMvlView {
        void showCharacterInfo(CharacterDto value);
        void setupViewPager(CharacterDto value);
        void setupComicsList(ComicsDto comics);
    }

    public interface ICharacterDetailViewModel extends IMvlViewModel {
        void getCharacterData(String string);
        void getCharactersComicsList(int id);
    }
}
