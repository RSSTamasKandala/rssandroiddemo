package org.rss_examples.rssmarveldemo.viewmodels.comicdetail;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlItemViewModel;
import org.rss_examples.rssmarveldemo.contracts.ComicCharactersItemContract.IComicCharactersItemView;
import org.rss_examples.rssmarveldemo.contracts.ComicCharactersItemContract.IVmComicCharactersItem;

public class VmComicDetailCharactersItem extends MvlItemViewModel<IComicCharactersItemView>
        implements IVmComicCharactersItem{

    private final CharacterDto dto;

    public VmComicDetailCharactersItem(CharacterDto dto) {
        this.dto = dto;
    }

    @Override
    public String getPicUrl() {
        return dto.getThumbnail().getPath() + "." + dto.getThumbnail().getExtension();
    }

    @Override
    public String getName() {
        return dto.getName();
    }
}
