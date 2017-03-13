package org.rss_examples.rssmarveldemo.common.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class MvlPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragments;
    private final List<String> titles;

    public List<Fragment> getFragments() {
        return fragments;
    }

    public MvlPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  titles.get(position);
    }

}
