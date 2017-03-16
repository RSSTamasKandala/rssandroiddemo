package org.rss_examples.rssmarveldemo.view;


import android.view.View;

interface INavigator {

    void startComicDetail(String comicId, View view, View textView);

    void startCharacterDetail(String characterId, View view, View textView);
}
