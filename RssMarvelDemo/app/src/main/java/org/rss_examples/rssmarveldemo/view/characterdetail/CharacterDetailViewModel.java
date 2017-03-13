package org.rss_examples.rssmarveldemo.view.characterdetail;

import com.karumi.marvelapiclient.model.CharacterDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.CharacterDetailContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CharacterDetailViewModel extends MvlViewModel<CharacterDetailContract.ICharacterDetailView> implements CharacterDetailContract.ICharacterDetailViewModel {

    @Override
    public void getCharacterData(String id) {
        MarvelRepository.getInstance().getCharacter(id)
                .subscribe(new Observer<CharacterDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CharacterDto value) {
                        if (mvlView != null) {
                            mvlView.showCharacterInfo(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
