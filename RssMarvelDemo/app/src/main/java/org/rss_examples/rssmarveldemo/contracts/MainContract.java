package org.rss_examples.rssmarveldemo.contracts;

import android.support.v4.app.Fragment;

import org.rss_examples.rssmarveldemo.common.IMvlView;
import org.rss_examples.rssmarveldemo.common.IMvlViewModel;

import java.util.List;


public interface MainContract {

    public interface MainView extends IMvlView {

        void setupPager();
        List<Fragment> getFragmentList();
    }

    public interface MainViewModel extends IMvlViewModel {

        void getLists();
    }
}
