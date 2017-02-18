package uiframework.kandala.tamas.marvel.common;

import android.databinding.ViewDataBinding;

import uiframework.kandala.tamas.marvelcore.common.IMvlViewBinder;
import uiframework.kandala.tamas.marvelcore.common.MvLViewBinder;
import uiframework.kandala.tamas.marvelcore.common.MvlViewModel;
import uiframework.kandala.tamas.marveldatalayer.data.IErrorListener;


public class MvlPhoneBinder<Binding extends ViewDataBinding, IBinder extends IMvlViewBinder<Binding>, Vm extends MvlViewModel<IBinder>
        > extends MvLViewBinder<Binding, IBinder, Vm> implements IMvlViewBinder<Binding> {
    @Override
    protected void attachViewModel(Binding viewBinding, Vm viewModel) {

    }

    @Override
    protected IBinder getBinderInterFace() {
        return null;
    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public IErrorListener getErrorListener() {
        return null;
    }
}
