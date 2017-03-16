package org.rss_examples.rssmarveldemo.view.characterdetail.comicsitem;

import android.view.View;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.CharacterComicsItemContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterComicsListItemBinding;
import org.rss_examples.rssmarveldemo.viewmodels.characterdetail.VmCharacterDetailComicsItem;

public class CharacterDetailComicsItemView implements CharacterComicsItemContract.ICharacterComicsItemView<CharacterComicsListItemBinding> {

    private final VmCharacterDetailComicsItem vm;

    public CharacterDetailComicsItemView(ComicDto dto) {
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
