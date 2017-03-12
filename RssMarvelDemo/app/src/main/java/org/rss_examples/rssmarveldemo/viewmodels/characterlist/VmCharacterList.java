package org.rss_examples.rssmarveldemo.viewmodels.characterlist;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.CharacterListContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;
import org.rss_examples.rssmarveldemo.view.characterlist.CharacterItemView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class VmCharacterList extends MvlViewModel<CharacterListContract.ICharacterListView> implements CharacterListContract.IVmCharacterList {


    @Override
    public void getChatacterList() {
        mvlView.showLoading(true);
        MarvelRepository.getInstance().getCharactersList(0, 20, new Observer<CharactersDto>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CharactersDto value) {
                List<IMvlItemView> characterItemViews = new ArrayList<>();
                for (CharacterDto characterDto : value.getCharacters()) {
                    characterItemViews.add(new CharacterItemView(characterDto));
                }
                mvlView.showList(characterItemViews);
                mvlView.showLoading(false);
            }

            @Override
            public void onError(Throwable e) {
                mvlView.showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
