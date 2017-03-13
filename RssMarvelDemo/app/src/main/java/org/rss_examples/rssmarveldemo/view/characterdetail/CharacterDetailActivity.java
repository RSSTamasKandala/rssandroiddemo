package org.rss_examples.rssmarveldemo.view.characterdetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicResourceDto;
import com.karumi.marvelapiclient.model.MarvelResources;
import com.karumi.marvelapiclient.model.StoryResourceDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;
import org.rss_examples.rssmarveldemo.contracts.CharacterDetailContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterDetailActivityBinding;
import org.rss_examples.rssmarveldemo.view.characterdetail.comicsitem.CharacterDetailComicsItemView;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;

public class CharacterDetailActivity extends MvlActivity implements CharacterDetailContract.ICharacterDetailView {

    private static final String EXTRA_CHARACTER_ID = "character_id";
    private MvlAdapter mvlAdapter;
    private CharacterDetailActivityBinding binding;

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
    }

    @Override
    public void showCharacterInfo(CharacterDto value) {
        setupViewPager(value.getStories());
        setupComicsList(value.getComics());

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
    public void setupViewPager(MarvelResources<StoryResourceDto> collections) {

    }

    @Override
    public void setupComicsList(MarvelResources<ComicResourceDto> comics) {
        for (ComicResourceDto dto : comics.getItems()) {
            mvlAdapter.addItemView(new CharacterDetailComicsItemView(dto));
        }
    }
}
