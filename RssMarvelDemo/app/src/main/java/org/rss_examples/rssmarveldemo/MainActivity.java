package org.rss_examples.rssmarveldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.rss_examples.rssmarveldemo.data.IResponseListener;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

@EActivity
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Bean
    MvlErrorListener errorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComicList();
    }

    @Background
    public void getComicList(){
        MarvelRepository.getInstance().getComicList(0, 10, new IResponseListener<ComicsDto>() {
            @Override
            public void onResponse(ComicsDto object) {
                proccessResponse(object);
            }
        },errorListener);
    }

    @UiThread
    public void proccessResponse(ComicsDto object) {
        for (ComicDto comicDto:  object.getComics()){
            Log.i(TAG, "proccessResponse: "+ comicDto.toString());
        }
    }
}
