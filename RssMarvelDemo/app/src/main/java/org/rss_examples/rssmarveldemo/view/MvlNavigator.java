package org.rss_examples.rssmarveldemo.view;

import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.view.characterdetail.CharacterDetailActivity;
import org.rss_examples.rssmarveldemo.view.comicdetail.ComicComicDetailActivity;

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
    public void startComicDetail(String comicId, View view, View textView) {
        ComicComicDetailActivity.startActivity(comicId, view, textView);
    }

    @Override
    public void startCharacterDetail(CharacterDto characterDto, View view, View textView) {
        CharacterDetailActivity.startActivity(characterDto.getId(), view, textView);
    }
}
