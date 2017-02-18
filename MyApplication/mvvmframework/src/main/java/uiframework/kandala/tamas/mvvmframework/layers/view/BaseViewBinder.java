package uiframework.kandala.tamas.mvvmframework.layers.view;

import android.databinding.ViewDataBinding;

import uiframework.kandala.tamas.mvvmframework.layers.viewmodel.BaseViewmodel;


public abstract class BaseViewBinder<B extends ViewDataBinding, IBinder extends IViewBinder<B>, Vm extends BaseViewmodel<IBinder>> {


    protected Vm viewModel;


    protected B viewBinding;


    public void bindView(B binding) {
        viewBinding = binding;
        viewModel = getViewModel();
    }

    public void unBindView() {
        viewModel.detachViewBinder();
    }

    public void reBindView() {
        viewModel.attachViewBinder(getBinderInterFace());
        attachViewModel(viewBinding, viewModel);

    }

    protected abstract void attachViewModel(B viewBinding, Vm viewModel);

    protected abstract Vm getViewModel();

    protected abstract IBinder getBinderInterFace();
}
