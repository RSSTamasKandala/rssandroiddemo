package org.rss_examples.rssmarveldemo.view.characterlist;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.CharacterItemContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterItemBinding;
import org.rss_examples.rssmarveldemo.viewmodels.characterlist.VmCharacterItem;


public class CharacterItemView implements CharacterItemContract.ICharacterItemView<CharacterItemBinding> {

    private final VmCharacterItem vmCharacterItem;

    public CharacterItemView(CharacterDto characterItem) {
        vmCharacterItem = new VmCharacterItem(characterItem);

    }

    @Override
    public int getLayoutId() {
        return R.layout.character_item;
    }


    @Override
    public void onBindView(RecycleBindingVHolder<CharacterItemBinding> holder) {
        vmCharacterItem.setView(this);
        holder.getViewDataBinding().setViewmodel(vmCharacterItem);

    }
}
