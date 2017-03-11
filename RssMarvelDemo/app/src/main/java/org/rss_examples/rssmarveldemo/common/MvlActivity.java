package org.rss_examples.rssmarveldemo.common;

import android.support.v7.app.AppCompatActivity;

import org.rss_examples.rssmarveldemo.MvlErrorListener;

public abstract class MvlActivity extends AppCompatActivity {

    protected MvlErrorListener errorListener = MvlErrorListener.getInstance(this);

}
