package uiframework.kandala.tamas.marvelcore.screens.comic_list;

import android.databinding.ViewDataBinding;

import com.karumi.marvelapiclient.model.ComicsDto;

import org.androidannotations.annotations.EBean;

import uiframework.kandala.tamas.marvelcore.common.MvlViewModel;
import uiframework.kandala.tamas.marveldatalayer.data.IResponseListener;
import uiframework.kandala.tamas.marveldatalayer.data.MarvelRepository;

/**
 * Created by FlashBook on 18/02/2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ComicListViewModel<V extends ViewDataBinding> extends MvlViewModel<ComicListContract.IComicViewBinder<V>> implements ComicListContract.IComicListViewModel {
    @Override
    public void getData() {
        binder.showLoading(true);
        MarvelRepository.getInstance().getComicList(0, 10, new IResponseListener<ComicsDto>() {
            @Override
            public void onResponse(ComicsDto object) {
                binder.showLoading(false);
                binder.showList(object.getComics());
            }
        }, binder.getErrorListener());
    }
}
