package org.rss_examples.rssmarveldemo.view.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlPagerAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.MainContract;
import org.rss_examples.rssmarveldemo.databinding.ActivityMainBinding;
import org.rss_examples.rssmarveldemo.view.characterlist.CharacterListFragment;
import org.rss_examples.rssmarveldemo.view.comiclist.ComicListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvlActivity implements MainContract.MainView {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUI();
    }

    @Override
    public void bindUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(binding.toolbar);
        setupViewPager();
    }

    @Override
    public List<Fragment> getFragmentList() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ComicListFragment());
        fragments.add(new CharacterListFragment());
        return fragments;
    }

    @Override
    public void setupViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("Comics");
        titles.add("Characters");
        binding.mainPager.setAdapter(new MvlPagerAdapter(getSupportFragmentManager(), getFragmentList(), titles));
        binding.tabs.setupWithViewPager(binding.mainPager, true);

    }
}
