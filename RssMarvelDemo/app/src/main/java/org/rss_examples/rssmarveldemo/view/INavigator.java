package org.rss_examples.rssmarveldemo.view;


import android.content.Context;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicDto;

interface INavigator {

    void startComicDetail(Context context, ComicDto comicDto);

    void startCharacterDetail(Context context, CharacterDto characterDto);
}
