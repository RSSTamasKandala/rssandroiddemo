package org.rss_examples.rssmarveldemo.view;

import android.content.Context;
import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.view.characterdetail.CharacterDetailActivity;
import org.rss_examples.rssmarveldemo.view.comicdetail.ComicDetailActivity;

public class MvlNavigator implements INavigator {

    private static MvlNavigator instance;

    private MvlNavigator() {
    }

    public static MvlNavigator getInstance() {
        if (instance == null) {
            instance = new MvlNavigator();
        }
        return instance;
    }

    @Override
    public void startComicDetail(Context context, ComicDto comicDto) {
        ComicDetailActivity.startActivity(context, comicDto.getId());
    }

    @Override
    public void startCharacterDetail(CharacterDto characterDto, View view) {
        CharacterDetailActivity.startActivity(characterDto.getId(), view);
    }
}
