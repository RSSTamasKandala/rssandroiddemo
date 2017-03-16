package org.rss_examples.rssmarveldemo.view.comicdetail;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.transition.TransitionManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.CreatorResourceDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.ComicDetailContract;
import org.rss_examples.rssmarveldemo.databinding.ComicDetailActivityBinding;
import org.rss_examples.rssmarveldemo.view.comicdetail.charactersitem.ComicDetailCharactersItemView;
import org.rss_examples.rssmarveldemo.viewmodels.comicdetail.VmComicDetail;

public class ComicDetailActivity extends MvlActivity implements ComicDetailContract.IComicDetailView {

    private static final String EXTRA_COMIC_ID = "comic_id";

    private MvlAdapter mvlAdapter;
    private ComicDetailActivityBinding binding;

    private boolean isExpanded = false;
    private AnimatedVectorDrawable straightAnimatedVectorDrawable;
    private AnimatedVectorDrawable reverseAnimatedVectorDrawable;
    private AnimatedVectorDrawable currentDrawable;

    public static void startActivity(String comicId, View image, View textView) {
        Intent intent = new Intent(image.getContext(), ComicDetailActivity.class);
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
        VmComicDetail viewModel = new VmComicDetail();
        viewModel.setView(this);
        binding.setComicDetail(viewModel);

        mvlAdapter = new MvlAdapter();

        binding.comicDetailBotList.setLayoutManager(new GridLayoutManager(this, 3));
        binding.comicDetailBotList.setAdapter(mvlAdapter);

        straightAnimatedVectorDrawable = (AnimatedVectorDrawable) ContextCompat.getDrawable(this, R.drawable.animated_vector_drawable_end_to_start);
        reverseAnimatedVectorDrawable = (AnimatedVectorDrawable) ContextCompat.getDrawable(this, R.drawable.animated_vector_drawable_start_to_end);

        viewModel.getComicData(getIntent().getExtras().getString(EXTRA_COMIC_ID, ""));
        viewModel.getComicsCharactersData(Integer.parseInt(getIntent().getExtras().getString(EXTRA_COMIC_ID, "")));
    }

    @Override
    public void showComicInfo(ComicDto value) {
        binding.comicDetailToolbarName.setText(value.getTitle());
        binding.comicDetailDesc.setText(value.getDescription());

        if (value.getCreators() != null && value.getCreators().getItems() != null) {
            StringBuilder sb = new StringBuilder();

            for (CreatorResourceDto dto : value.getCreators().getItems()) {
                if (sb.length() > 0) {
                    sb.append(" , " + dto.getName());
                } else {
                    sb.append(dto.getName());
                }
            }

            binding.comicDetailToolbarWriters.setText(sb.toString());
        }

        //// TODO: 2017. 03. 16.
        Glide.with(this)
                .load(value.getThumbnail().getPath() + "." + value.getThumbnail().getExtension())
                .placeholder(ContextCompat.getDrawable(this, R.drawable.header_placeholder))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.comicDetailTopImage);
    }

    @Override
    public void showComicsCharactersInfo(CharactersDto value) {
        for (CharacterDto dto : value.getCharacters()) {
            mvlAdapter.addItemView(new ComicDetailCharactersItemView(dto));
        }
    }

    @Override
    public void onBackClick() {
        onBackPressed();
    }

    @Override
    public void onMoreClick() {
        //// TODO: 2017. 03. 16.
    }

    @Override
    public void onArrowClick() {
        TransitionManager.beginDelayedTransition(binding.comicDetailLayout);

        if (!isExpanded) {
            binding.comicDetailDesc.setMaxLines(Integer.MAX_VALUE);
        } else {
            binding.comicDetailDesc.setMaxLines(4);
        }

        animate();

        isExpanded = !isExpanded;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void animate() {
        if (isExpanded) {
            currentDrawable = reverseAnimatedVectorDrawable;
        } else {
            currentDrawable = straightAnimatedVectorDrawable;
        }

        binding.comicDetailPageMore.setImageDrawable(currentDrawable);
        currentDrawable.start();
    }

}
