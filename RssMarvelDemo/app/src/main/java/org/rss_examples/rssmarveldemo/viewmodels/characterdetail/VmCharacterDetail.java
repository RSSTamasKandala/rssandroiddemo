package org.rss_examples.rssmarveldemo.viewmodels.characterdetail;

import android.view.View;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.CharacterDetailContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class VmCharacterDetail extends MvlViewModel<CharacterDetailContract.ICharacterDetailView> implements CharacterDetailContract.ICharacterDetailViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void getCharacterData(String id) {
        MarvelRepository.getInstance().getCharacter(id)
                .subscribe(new Observer<CharacterDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
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

    @Override
    public void getCharactersComicsList(int id) {
        MarvelRepository.getInstance().getComicListByCharacter(id, 0, 20)
                .subscribe(new Observer<ComicsDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
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
        if (mvlView != null) {
            return mvlView.getPicUrl();
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

    @Override
    public String getName() {
        if (mvlView != null) {
            return mvlView.getName();
        } else {
            return "";
        }
    }

    @Override
    public void unSubscribe () {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable = new CompositeDisposable();
        }
    }
}
