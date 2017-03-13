package org.rss_examples.rssmarveldemo.contracts;


import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicResourceDto;
import com.karumi.marvelapiclient.model.MarvelResources;
import com.karumi.marvelapiclient.model.StoryResourceDto;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

public interface CharacterDetailContract {
    public interface ICharacterDetailView extends IMvlView {
        void showCharacterInfo(CharacterDto value);
        void setupViewPager(MarvelResources<StoryResourceDto> collections);
        void setupComicsList(MarvelResources<ComicResourceDto> comics);
    }

    public interface ICharacterDetailViewModel extends IMvlViewModel {
        void getCharacterData(String string);
    }
}
