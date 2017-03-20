package org.rss_examples.rssmarveldemo.viewmodels.comicdetail;

import android.view.View;

import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.ComicDetailContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class VmComicDetail extends MvlViewModel<ComicDetailContract.IComicDetailView>
        implements ComicDetailContract.IDetailViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void getComicData(String string) {
        MarvelRepository.getInstance().getComic(string)
                .subscribe(new Observer<ComicDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ComicDto value) {
                        if (mvlView != null) {
                            mvlView.showComicInfo(value);
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
    public void getComicsCharactersData(int comicId) {
        MarvelRepository.getInstance().getCharacterListByComic(0, 20, comicId)
                .subscribe(new Observer<CharactersDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(CharactersDto value) {
                        if (mvlView != null) {
                            mvlView.showComicsCharactersInfo(value);
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
    public void onBackClick(View view) {
        if (mvlView != null) {
            mvlView.onBackClick();
        }
    }

    @Override
    public void onMoreClick(View view) {
        if (mvlView != null) {
            mvlView.onMoreClick();
        }
    }

    @Override
    public void onArrowClick(View view) {
        if (mvlView != null) {
            mvlView.onArrowClick();
        }
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
    public String getTitle() {
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
