package org.rss_examples.rssmarveldemo.view.characterdetail;

import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.CharacterDetailContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CharacterDetailViewModel extends MvlViewModel<CharacterDetailContract.ICharacterDetailView> implements CharacterDetailContract.ICharacterDetailViewModel {

    private CharacterDto characterDto;

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
                            characterDto = value;
                            getPicUrl();
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

    @Override
    public void getCharactersComicsList(int id) {
        MarvelRepository.getInstance().getComicListByCharacter(id, 0, 20)
                .subscribe(new Observer<ComicsDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComicsDto value) {
                        if (mvlView != null) {
                            mvlView.setupComicsList(value);
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

    @Override
    public String getPicUrl() {
        if (characterDto != null) {
            return characterDto.getThumbnail().getPath() + "." + characterDto.getThumbnail().getExtension();
        } else {
            return "";
        }
    }

    @Override
    public void onArrowClick(View view) {
        if (mvlView != null) {
            mvlView.onArrowClick();
        }
    }

    @Override
    public void onBackClick(View view) {
        if (mvlView != null) {
            mvlView.onBackClick();
        }
    }
}
