package org.rss_examples.rssmarveldemo.view.comicdetail;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.ComicDetailContract;
import org.rss_examples.rssmarveldemo.databinding.ComicDetailActivityBinding;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;

public class ComicComicDetailActivity extends MvlActivity implements ComicDetailContract.IComicDetailView {

    private static final String EXTRA_COMIC_ID = "comic_id";

    private MvlAdapter mvlAdapter;
    private ComicDetailActivityBinding binding;

    public static void startActivity(String comicId, View image, View textView) {
        Intent intent = new Intent(image.getContext(), ComicComicDetailActivity.class);
        intent.putExtra(EXTRA_COMIC_ID, comicId);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) image.getContext(),
                    Pair.create(image, image.getTransitionName()),
                    Pair.create(textView, textView.getTransitionName()));
            ActivityCompat.startActivity(image.getContext(), intent, options.toBundle());
        } else {
            image.getContext().startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUI();
    }

    @Override
    public void bindUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.comic_detail_activity);
        ComicDetailViewModel viewModel = new ComicDetailViewModel();
        viewModel.setView(this);
        binding.setComicDetail(viewModel);

        viewModel.getComicData(getIntent().getExtras().getString(EXTRA_COMIC_ID, ""));
    }

    @Override
    public void showComicInfo(ComicDto value) {
        binding.comicDetailToolbarName.setText(value.getTitle());
        binding.comicDetailDesc.setText(value.getDescription());
//        binding.characterDetailDesc.setText(characterDto.getDescription());

        //// TODO: 2017. 03. 16.
        Glide.with(this)
                .load(value.getThumbnail().getPath() + "." + value.getThumbnail().getExtension())
                .placeholder(ContextCompat.getDrawable(this, R.mipmap.ic_launcher))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleTransform(this))
                .into(binding.comicDetailTopImage);
    }

}
