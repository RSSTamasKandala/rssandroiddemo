package org.rss_examples.rssmarveldemo.view.characterdetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.adapters.MvlPagerAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.CharacterDetailContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterDetailActivityBinding;
import org.rss_examples.rssmarveldemo.view.characterdetail.comicsitem.CharacterDetailComicsItemView;
import org.rss_examples.rssmarveldemo.view.characterdetail.pages.CharacterDetailInfoFragment;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;

import java.util.ArrayList;
import java.util.List;

public class CharacterDetailActivity extends MvlActivity implements CharacterDetailContract.ICharacterDetailView {

    private static final String EXTRA_CHARACTER_ID = "character_id";
    private MvlAdapter mvlAdapter;
    private MvlPagerAdapter mvlPagerAdapter;
    private CharacterDetailActivityBinding binding;

    private boolean isExpanded = false;

    public static void startActivity(Context context, String characterID) {
        Intent intent = new Intent(context, CharacterDetailActivity.class);
        intent.putExtra(CharacterDetailActivity.EXTRA_CHARACTER_ID, characterID);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUI();
    }

    @Override
    public void bindUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.character_detail_activity);
        CharacterDetailViewModel viewModel = new CharacterDetailViewModel();
        viewModel.setView(this);
        binding.setCharacterDetail(viewModel);

        mvlAdapter = new MvlAdapter();
        binding.characterDetailBotList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.characterDetailBotList.setAdapter(mvlAdapter);
        viewModel.getCharacterData(getIntent().getExtras().getString(EXTRA_CHARACTER_ID, ""));
        viewModel.getCharactersComicsList(Integer.valueOf(getIntent().getExtras().getString(EXTRA_CHARACTER_ID, "")));

        binding.characterDetailPageMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isExpanded = !isExpanded;
                pageExpanded(isExpanded);
            }
        });
    }

    @Override
    public void showCharacterInfo(CharacterDto value) {
        setupViewPager(value);

        binding.characterDetailToolbarName.setText(value.getName());
        binding.characterDetailToolbarRealname.setText(value.getDescription());

        Glide.with(this)
                .load(value.getThumbnail().getPath() + "." + value.getThumbnail().getExtension())
                .placeholder(ContextCompat.getDrawable(this, R.mipmap.ic_launcher))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleTransform(this))
                .into(binding.characterDetailToolbarImage);

        Glide.with(this)
                .load(value.getResourceUri())
                .placeholder(ContextCompat.getDrawable(this, R.mipmap.ic_launcher))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.characterDetailTopImage);
    }

    @Override
    public void setupViewPager(CharacterDto value) {
        List<Fragment> pages = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        titles.add("BIOGRAPHY");
        titles.add("STATS");
        titles.add("EVENTS");
        titles.add("STORIES");

        pages.add(CharacterDetailInfoFragment.createWithText(value.getDescription()));
        pages.add(CharacterDetailInfoFragment.createWithText(value.getDescription()));
        pages.add(CharacterDetailInfoFragment.createWithText(value.getDescription()));
        pages.add(CharacterDetailInfoFragment.createWithText(value.getDescription()));

        mvlPagerAdapter = new MvlPagerAdapter(getSupportFragmentManager(), pages, titles);
        binding.characterDetailPager.setAdapter(mvlPagerAdapter);
        binding.characterDetailPager.setOffscreenPageLimit(mvlPagerAdapter.getCount());

        for (String s : titles) {
            binding.characterDetailTabs.addTab(binding.characterDetailTabs.newTab().setText(s));
        }

        binding.characterDetailTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.characterDetailPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                binding.characterDetailPager.setCurrentItem(tab.getPosition());
            }
        });

        binding.characterDetailPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.characterDetailTabs.setScrollPosition(position,0f,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void setupComicsList(ComicsDto comics) {
        for (ComicDto dto : comics.getComics()) {
            mvlAdapter.addItemView(new CharacterDetailComicsItemView(dto));
        }
    }

    public void pageExpanded(boolean b) {
        changeFragmentsTextHeights(b);

        ViewGroup.LayoutParams paramsPager = binding.characterDetailPager.getLayoutParams();
        if (b) {
            paramsPager.height = binding.characterDetailPager.getHeight() * 2;
        } else {
            paramsPager.height = binding.characterDetailPager.getHeight() / 2;
        }
        binding.characterDetailPager.requestLayout();
    }

    private void changeFragmentsTextHeights(boolean b) {
        for (Fragment fragment : mvlPagerAdapter.getFragments()) {
            if (((CharacterDetailInfoFragment) fragment).textView != null) {
                View view = ((CharacterDetailInfoFragment) fragment).textView;
                ViewGroup.LayoutParams params = view.getLayoutParams();
                if (b) {
                    params.height = view.getHeight() * 2;
                } else {
                    params.height = view.getHeight() / 2;
                }
                view.requestLayout();
            }
        }
    }
}
