package uiframework.kandala.tamas.marvel.sceens.comic_list;

import android.databinding.ViewDataBinding;

import com.karumi.marvelapiclient.model.ComicDto;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import uiframework.kandala.tamas.marvel.common.MvlPhoneBinder;
import uiframework.kandala.tamas.marvelcore.screens.comic_list.ComicListContract;
import uiframework.kandala.tamas.marvelcore.screens.comic_list.ComicListViewModel;

@EBean(scope = EBean.Scope.Singleton)
public class ComicListBinder extends MvlPhoneBinder<ViewDataBinding, ComicListContract.IComicViewBinder<ViewDataBinding>, ComicListViewModel<ViewDataBinding>> implements ComicListContract.IComicViewBinder<ViewDataBinding> {

    @Bean
    ComicListViewModel<ViewDataBinding> comicListViewModel;


    @Override
    protected void attachViewModel(ViewDataBinding viewBinding, ComicListViewModel viewModel) {

    }


    @Override
    protected ComicListViewModel<ViewDataBinding> getViewModel() {
        return comicListViewModel;
    }

    @Override
    protected ComicListContract.IComicViewBinder<ViewDataBinding> getBinderInterFace() {
        return this;
    }

    @Override
    public void bindView(ViewDataBinding binding) {
        super.bindView(binding);
        viewModel.getData();
    }

    @Override
    public void showList(List<ComicDto> data) {

    }
}
