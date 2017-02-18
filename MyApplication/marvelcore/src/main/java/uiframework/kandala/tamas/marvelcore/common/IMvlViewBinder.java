package uiframework.kandala.tamas.marvelcore.common;

import android.databinding.ViewDataBinding;

import uiframework.kandala.tamas.marveldatalayer.data.IErrorListener;
import uiframework.kandala.tamas.mvvmframework.layers.view.IViewBinder;

/**
 * Created by FlashBook on 18/02/2017.
 */

public interface IMvlViewBinder<V extends ViewDataBinding> extends IViewBinder<V> {

    void showLoading(boolean show);

    IErrorListener getErrorListener();
}
