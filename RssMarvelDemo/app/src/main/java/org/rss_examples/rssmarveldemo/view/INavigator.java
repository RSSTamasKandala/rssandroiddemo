package org.rss_examples.rssmarveldemo.view;


import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;

interface INavigator {

    void startComicDetail(String comicId, View view, View textView);

    void startCharacterDetail(CharacterDto characterDto, View view, View textView);
}
