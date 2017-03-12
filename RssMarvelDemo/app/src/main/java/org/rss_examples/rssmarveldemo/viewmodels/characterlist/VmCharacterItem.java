package org.rss_examples.rssmarveldemo.viewmodels.characterlist;

import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlItemViewModel;
import org.rss_examples.rssmarveldemo.contracts.CharacterItemContract;

public class VmCharacterItem extends MvlItemViewModel<CharacterItemContract.ICharacterItemView> implements CharacterItemContract.IVmCharacter {

    private CharacterDto characterDto;

    public VmCharacterItem(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }

    @Override
    public String getPicUrl() {
        return characterDto.getThumbnail().getPath() + "." + characterDto.getThumbnail().getExtension();
    }

    @Override
    public String getName() {
        return characterDto.getName();
    }

    @Override
    public void onItemClick(View view) {
        super.onItemClick(view);
        this.mvlItemView.onItemClick(view);
    }
}
