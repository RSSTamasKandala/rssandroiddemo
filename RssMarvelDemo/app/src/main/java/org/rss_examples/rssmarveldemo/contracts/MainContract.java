package org.rss_examples.rssmarveldemo.contracts;

import android.support.v4.app.Fragment;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlViewModel;

import java.util.List;


public interface MainContract {

    public interface MainView extends IMvlView {

        List<Fragment> getFragmentList();
        void setupViewPager();
    }

    public interface MainViewModel extends IMvlViewModel {
    }
}
