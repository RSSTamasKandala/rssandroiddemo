package org.rss_examples.rssmarveldemo.view.characterdetail.comicsitem;

import android.view.View;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlItemViewModel;
import org.rss_examples.rssmarveldemo.contracts.CharacterComicsItemContract;

public class VmCharacterDetailComicsItem extends MvlItemViewModel<CharacterComicsItemContract.ICharacterComicstemView>
        implements CharacterComicsItemContract.IVmCharacterComicsItem{

    private final ComicDto dto;

    public VmCharacterDetailComicsItem(ComicDto dto) {
        this.dto = dto;
    }

    @Override
    public void onItemClick(View view) {
        //// TODO: 2017. 03. 13.
    }

    @Override
    public String getPicUrl() {
        return dto.getThumbnail().getPath() + "." + dto.getThumbnail().getExtension();
    }
}
