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
    public void getComicList(final int skip) {
        if (skip == 0) {
            mvlView.showLoading(true);
        }

        MarvelRepository.getInstance().getComicList(skip, 20).subscribe(new Observer<ComicsDto>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ComicsDto value) {
                List<IMvlItemView> itemViews = new ArrayList<>();
                for (ComicDto comicDto : value.getComics()) {
                    itemViews.add(new ComicItemView(comicDto));
                }
                if (skip == 0) {
                    mvlView.showList(itemViews);
                    mvlView.showLoading(false);
                } else {
                    mvlView.addList(itemViews);
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
}