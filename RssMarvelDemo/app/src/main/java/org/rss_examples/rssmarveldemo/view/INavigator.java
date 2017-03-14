package org.rss_examples.rssmarveldemo.view;


import android.content.Context;
import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicDto;

interface INavigator {

    void startComicDetail(Context context, ComicDto comicDto);

    void startCharacterDetail(CharacterDto characterDto, View view);
}
