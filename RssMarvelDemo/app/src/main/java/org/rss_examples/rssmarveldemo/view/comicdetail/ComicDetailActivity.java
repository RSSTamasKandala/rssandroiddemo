package org.rss_examples.rssmarveldemo.view.comicdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.MarvelCollection;

import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.adapters.MvlPagerAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.ComicDetailContract;

import java.util.List;

public class ComicDetailActivity extends MvlActivity implements ComicDetailContract.IDetailView {

    private static final String EXTRA_COMIC_ID = "comic_id";

    private MvlAdapter mvlAdapter;
    private MvlPagerAdapter mvlPagerAdapter;

    public static void startActivity(Context context, String comicId) {
        Intent intent = new Intent(context, ComicDetailActivity.class);
        intent.putExtra(ComicDetailActivity.EXTRA_COMIC_ID, comicId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUI();
    }

    @Override
    public void bindUI() {
    }

    @Override
    public void showComicInfo(ComicDto value) {
        setupViewPager(value.getCollections());

    }

    @Override
    public void setupViewPager(List<MarvelCollection> collections) {

    }

}
