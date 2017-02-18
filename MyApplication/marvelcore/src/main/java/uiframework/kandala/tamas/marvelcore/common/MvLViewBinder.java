package uiframework.kandala.tamas.marvelcore.common;

import android.databinding.ViewDataBinding;

import uiframework.kandala.tamas.mvvmframework.layers.view.BaseViewBinder;

/**
 * Created by FlashBook on 18/02/2017.
 */

public abstract class MvLViewBinder<Binding extends ViewDataBinding, IBinder extends IMvlViewBinder<Binding>, Vm extends MvlViewModel<IBinder>>
        extends
        BaseViewBinder<
                Binding,
                IBinder,
                Vm> {

    @Override
    protected Vm getViewModel() {
        return viewModel;
    }

}
