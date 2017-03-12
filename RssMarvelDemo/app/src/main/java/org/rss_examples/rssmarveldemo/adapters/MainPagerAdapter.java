package org.rss_examples.rssmarveldemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragments;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments= new ArrayList<>();
    }

    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        this(fm);
        this.fragments.addAll(fragments);
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragments().get(position);
    }

    @Override
    public int getCount() {
        return getFragments().size();
    }

}
