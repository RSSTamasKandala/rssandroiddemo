package org.rss_examples.rssmarveldemo.view;

import android.os.Bundle;
import android.util.Log;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.data.IResponseListener;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;
import org.rss_examples.rssmarveldemo.common.MvlActivity;

@EActivity
public class MainActivity extends MvlActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComicList();
        getCharactersList();
    }

    @Background
    protected void getComicList(){
        MarvelRepository.getInstance().getComicList(0, 10, new IResponseListener<ComicsDto>() {
            @Override
            public void onResponse(ComicsDto object) {
                proccessComicResponse(object);
            }
        },errorListener);
    }

    @Background
    protected void getCharactersList(){
        MarvelRepository.getInstance().getCharactersList(0, 10, new IResponseListener<CharactersDto>() {
            @Override
            public void onResponse(CharactersDto object) {
                proccessCharactersResponse(object);
            }
        }, errorListener);
    }

    @UiThread
    protected void proccessCharactersResponse(CharactersDto object) {
        for (CharacterDto charactersDto:  object.getCharacters()){
            Log.i(TAG, "proccessCharactersResponse: "+charactersDto.toString());
        }
    }

    @UiThread
    protected void proccessComicResponse(ComicsDto object) {
        for (ComicDto comicDto:  object.getComics()){
            Log.i(TAG, "proccessComicResponse: "+ comicDto.toString());
        }
    }
}
