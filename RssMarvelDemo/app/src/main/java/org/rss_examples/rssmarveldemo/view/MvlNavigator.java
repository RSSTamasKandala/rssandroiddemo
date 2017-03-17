package org.rss_examples.rssmarveldemo.view;

import android.view.View;

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
    public void startComicDetail(String comicId, String url, View view, View textView) {
        ComicDetailActivity.startActivity(comicId, url, view, textView);
    }

    @Override
    public void startCharacterDetail(String characterId, String url, View view, View textView) {
        CharacterDetailActivity.startActivity(characterId, url, view, textView);
    }
}
