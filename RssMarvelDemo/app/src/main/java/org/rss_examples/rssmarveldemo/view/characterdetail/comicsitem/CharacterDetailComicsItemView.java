package org.rss_examples.rssmarveldemo.view.characterdetail.comicsitem;

import android.view.View;

import com.karumi.marvelapiclient.model.ComicResourceDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.CharacterComicsItemContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterComicsListItemBinding;

public class CharacterDetailComicsItemView implements CharacterComicsItemContract.ICharacterComicstemView<CharacterComicsListItemBinding> {

    private final VmCharacterDetailComicsItem vm;

    public CharacterDetailComicsItemView(ComicResourceDto dto) {
        vm = new VmCharacterDetailComicsItem(dto);
    }

    @Override
    public int getLayoutId() {
        return R.layout.character_comics_list_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<CharacterComicsListItemBinding> holder) {
        vm.setView(this);
        holder.getViewDataBinding().setComicsItem(vm);
    }


    @Override
    public void onItemClick(View view) {

    }

}
