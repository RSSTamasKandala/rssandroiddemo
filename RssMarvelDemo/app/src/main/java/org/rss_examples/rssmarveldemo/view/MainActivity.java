package org.rss_examples.rssmarveldemo.view;

import android.os.Bundle;
import android.util.Log;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.MvlActivity;
import org.rss_examples.rssmarveldemo.data.IResponseListener;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

public class MainActivity extends MvlActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComicList();
        getCharactersList();
    }

    protected void getComicList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MarvelRepository.getInstance().getComicList(0, 10, new IResponseListener<ComicsDto>() {
                    @Override
                    public void onResponse(final ComicsDto object) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                proccessComicResponse(object);
                            }
                        });
                    }
                }, errorListener);
            }
        }).start();
    }

    protected void getCharactersList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MarvelRepository.getInstance().getCharactersList(0, 10, new IResponseListener<CharactersDto>() {
                    @Override
                    public void onResponse(final CharactersDto object) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                proccessCharactersResponse(object);
                            }
                        });
                    }
                }, errorListener);
            }
        }).start();
    }

    protected void proccessCharactersResponse(CharactersDto object) {
        for (CharacterDto charactersDto : object.getCharacters()) {
            Log.i(TAG, "proccessCharactersResponse: " + charactersDto.toString());
        }
    }

    protected void proccessComicResponse(ComicsDto object) {
        for (ComicDto comicDto : object.getComics()) {
            Log.i(TAG, "proccessComicResponse: " + comicDto.toString());
        }
    }
}
