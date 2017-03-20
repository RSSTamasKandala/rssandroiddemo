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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class VmCharacterList extends MvlViewModel<CharacterListContract.ICharacterListView> implements CharacterListContract.IVmCharacterList {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void getCharacterList(final int skip) {

            if (skip == 0) {
                mvlView.showLoading(true);
            }

            MarvelRepository.getInstance().getCharactersList(skip, 10).subscribe(new Observer<CharactersDto>() {
                @Override
                public void onSubscribe(Disposable d) {
                    compositeDisposable.add(d);
                }

                @Override
                public void onNext(CharactersDto value) {
                    List<IMvlItemView> characterItemViews = new ArrayList<>();
                    for (CharacterDto characterDto : value.getCharacters()) {
                        characterItemViews.add(new CharacterItemView(characterDto));
                    }
                    if (skip == 0) {
                        mvlView.showList(characterItemViews);
                        mvlView.showLoading(false);
                    } else {
                        mvlView.addList(characterItemViews);
                    }
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

    @Override
    public void unSubscribe() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable = new CompositeDisposable();
        }
    }
}
