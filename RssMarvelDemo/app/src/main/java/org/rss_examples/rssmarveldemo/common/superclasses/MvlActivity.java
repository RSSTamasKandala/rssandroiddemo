package org.rss_examples.rssmarveldemo.common.superclasses;

import android.support.v7.app.AppCompatActivity;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;

public abstract class MvlActivity extends AppCompatActivity implements IMvlView {


    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void showError(String message) {

    }


}
