package uiframework.kandala.tamas.marvelcore.screens.comic_list;

import android.databinding.ViewDataBinding;

import com.karumi.marvelapiclient.model.ComicDto;

import java.util.List;

import uiframework.kandala.tamas.marvelcore.common.IMvLViewModel;
import uiframework.kandala.tamas.marvelcore.common.IMvlViewBinder;

/**
 * Created by FlashBook on 18/02/2017.
 */

public class ComicListContract {

    public interface IComicViewBinder<B extends ViewDataBinding> extends IMvlViewBinder<B> {
        void showList(List<ComicDto> data);
    }

    public interface IComicListViewModel extends IMvLViewModel<IComicViewBinder> {

    }
}
