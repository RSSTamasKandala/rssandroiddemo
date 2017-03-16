package org.rss_examples.rssmarveldemo.view.comicdetail.charactersitem;

import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.ComicCharactersItemContract;
import org.rss_examples.rssmarveldemo.databinding.ComicDetailCharacterItemBinding;
import org.rss_examples.rssmarveldemo.viewmodels.comicdetail.VmComicDetailCharactersItem;

public class ComicDetailCharactersItemView implements ComicCharactersItemContract.IComicCharactersItemView<ComicDetailCharacterItemBinding> {

    private final VmComicDetailCharactersItem vm;

    public ComicDetailCharactersItemView(CharacterDto dto) {
        this.vm = new VmComicDetailCharactersItem(dto);
    }

    @Override
    public int getLayoutId() {
        return R.layout.comic_detail_character_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<ComicDetailCharacterItemBinding> holder) {
        holder.getViewDataBinding().setComicDetailCharacterItem(vm);
    }

    @Override
    public void onItemClick(View view) {
        //// TODO: 2017. 03. 16.
    }
}
