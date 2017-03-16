package org.rss_examples.rssmarveldemo.view.comicdetail;

import android.view.View;

import com.karumi.marvelapiclient.model.ComicDto;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.ComicDetailContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ComicDetailViewModel extends MvlViewModel<ComicDetailContract.IComicDetailView>
        implements ComicDetailContract.IDetailViewModel {

    @Override
    public void getComicData(String string) {
        MarvelRepository.getInstance().getComic(string)
                .subscribe(new Observer<ComicDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {

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
    public void onBackClick(View view) {

    }

    @Override
    public void onMoreClick(View view) {

    }

    @Override
    public void onArrowClick(View view) {

    }
}
