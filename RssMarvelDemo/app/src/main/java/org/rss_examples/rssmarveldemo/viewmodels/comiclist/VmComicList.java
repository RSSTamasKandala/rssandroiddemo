package org.rss_examples.rssmarveldemo.viewmodels.comiclist;

import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlViewModel;
import org.rss_examples.rssmarveldemo.contracts.ComicListContract;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;
import org.rss_examples.rssmarveldemo.view.comiclist.ComicItemView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class VmComicList extends MvlViewModel<ComicListContract.IComicListView> implements ComicListContract.IVmComicList {

    @Override
    public void getComicList() {
        mvlView.showLoading(true);
        MarvelRepository.getInstance().getComicList(0, 20, new Observer<ComicsDto>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ComicsDto value) {
                List<IMvlItemView> itemViews = new ArrayList<>();
                for (ComicDto comicDto : value.getComics()) {
                    itemViews.add(new ComicItemView(comicDto));
                }
                mvlView.showList(itemViews);
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