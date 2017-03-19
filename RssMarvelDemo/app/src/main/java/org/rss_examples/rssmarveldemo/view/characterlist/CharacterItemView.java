package org.rss_examples.rssmarveldemo.view.characterlist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.contracts.CharacterItemContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterItemBinding;
import org.rss_examples.rssmarveldemo.view.MvlNavigator;
import org.rss_examples.rssmarveldemo.viewmodels.characterlist.VmCharacterItem;


public class CharacterItemView implements CharacterItemContract.ICharacterItemView<CharacterItemBinding> {

    private final VmCharacterItem vmCharacterItem;
    private final CharacterDto character;

    private ImageView imageView;
    private TextView textView;
    private String url;

    public CharacterItemView(CharacterDto characterItem) {
        this.character = characterItem;
        vmCharacterItem = new VmCharacterItem(characterItem);
        url = characterItem.getThumbnail().getPath() + "." + characterItem.getThumbnail().getExtension();
    }

    @Override
    public int getLayoutId() {
        return R.layout.character_item;
    }

    @Override
    public void onBindView(RecycleBindingVHolder<CharacterItemBinding> holder) {
        vmCharacterItem.setView(this);
        holder.getViewDataBinding().setViewmodel(vmCharacterItem);
        imageView = holder.getViewDataBinding().comicItemImage;
        textView = holder.getViewDataBinding().comicItemTitle;
    }

    @Override
    public void onItemClick(View view) {
        MvlNavigator.getInstance().startCharacterDetail(character.getId(), url, character.getName(), imageView, textView);
    }
}
