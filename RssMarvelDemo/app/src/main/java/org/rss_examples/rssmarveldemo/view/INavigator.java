package org.rss_examples.rssmarveldemo.view;


import android.view.View;

interface INavigator {

    void startComicDetail(String comicId, String url, String title, View view, View textView);

    void startCharacterDetail(String characterId, String url, String name, View view, View textView);
}
