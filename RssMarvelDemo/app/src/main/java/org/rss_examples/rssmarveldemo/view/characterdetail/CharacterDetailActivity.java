package org.rss_examples.rssmarveldemo.view.characterdetail;

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
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.CharacterDetailContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterDetailActivityBinding;
import org.rss_examples.rssmarveldemo.view.characterdetail.comicsitem.CharacterDetailComicsItemView;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;
import org.rss_examples.rssmarveldemo.viewmodels.characterdetail.VmCharacterDetail;

public class CharacterDetailActivity extends MvlActivity implements CharacterDetailContract.ICharacterDetailView {

    private static final String EXTRA_CHARACTER_ID = "character_id";
    private MvlAdapter mvlAdapter;
    private CharacterDetailActivityBinding binding;

    private boolean isExpanded = false;
    private AnimatedVectorDrawable straightAnimatedVectorDrawable;
    private AnimatedVectorDrawable reverseAnimatedVectorDrawable;
    private AnimatedVectorDrawable currentDrawable;

    public static void startActivity(String characterID, View view, View textView) {
        Intent intent = new Intent(view.getContext(), CharacterDetailActivity.class);
        intent.putExtra(CharacterDetailActivity.EXTRA_CHARACTER_ID, characterID);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) view.getContext(),
                    Pair.create(view, view.getTransitionName()),
                    Pair.create(textView, textView.getTransitionName()));
            ActivityCompat.startActivity(view.getContext(), intent, options.toBundle());
        } else {
            view.getContext().startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUI();
    }

    @Override
    public void bindUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.character_detail_activity);
        VmCharacterDetail viewModel = new VmCharacterDetail();
        viewModel.setView(this);
        binding.setCharacterDetail(viewModel);

        mvlAdapter = new MvlAdapter();
        binding.characterDetailBotList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.characterDetailBotList.setAdapter(mvlAdapter);
        viewModel.getCharacterData(getIntent().getExtras().getString(EXTRA_CHARACTER_ID, ""));
        viewModel.getCharactersComicsList(Integer.valueOf(getIntent().getExtras().getString(EXTRA_CHARACTER_ID, "")));

        straightAnimatedVectorDrawable = (AnimatedVectorDrawable) ContextCompat.getDrawable(this, R.drawable.animated_vector_drawable_end_to_start);
        reverseAnimatedVectorDrawable = (AnimatedVectorDrawable) ContextCompat.getDrawable(this, R.drawable.animated_vector_drawable_start_to_end);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void animate() {
        if (isExpanded) {
            currentDrawable = reverseAnimatedVectorDrawable;
        } else {
            currentDrawable = straightAnimatedVectorDrawable;
        }

        binding.characterDetailPageMore.setImageDrawable(currentDrawable);
        currentDrawable.start();
    }

    @Override
    public void showCharacterInfo(CharacterDto characterDto) {
        binding.characterDetailToolbarName.setText(characterDto.getName());
        binding.characterDetailDesc.setText(characterDto.getDescription());

        //// TODO: 2017. 03. 16.
        Glide.with(this)
                .load(characterDto.getThumbnail().getPath() + "." + characterDto.getThumbnail().getExtension())
                .placeholder(ContextCompat.getDrawable(this, R.drawable.portrait_placeholder))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleTransform(this))
                .into(binding.characterDetailToolbarImage);

        Glide.with(this)
                .load("")
                .placeholder(ContextCompat.getDrawable(this, R.drawable.header_placeholder))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.characterDetailTopImage);
    }

    @Override
    public void setupComicsList(ComicsDto comics) {
        for (ComicDto dto : comics.getComics()) {
            mvlAdapter.addItemView(new CharacterDetailComicsItemView(dto));
        }
    }

    @Override
    public void onArrowClick() {
        pageExpanded();
    }

    @Override
    public void onBackClick() {
        onBackPressed();
    }

    public void pageExpanded() {
        TransitionManager.beginDelayedTransition(binding.characterDetailLayout);

        if (!isExpanded) {
            binding.characterDetailDesc.setMaxLines(Integer.MAX_VALUE);
        } else {
            binding.characterDetailDesc.setMaxLines(4);
        }

        animate();

        isExpanded = !isExpanded;
    }

}
