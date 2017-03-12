package org.rss_examples.rssmarveldemo.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import org.rss_examples.rssmarveldemo.ComicFragment;
import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.adapters.MainPagerAdapter;
import org.rss_examples.rssmarveldemo.common.MvlActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvlActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_pager);

        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), getFragments()));
    }

    private List<Fragment> getFragments() {
        List<Fragment> result = new ArrayList<>();
        result.add(new ComicFragment());
        result.add(new ComicFragment());
        return result;
    }

}
