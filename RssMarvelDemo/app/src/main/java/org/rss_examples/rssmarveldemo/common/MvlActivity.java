package org.rss_examples.rssmarveldemo.common;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.rss_examples.rssmarveldemo.MvlErrorListener;


@EActivity
public abstract class MvlActivity extends AppCompatActivity {

    @Bean
    protected MvlErrorListener errorListener;

}
