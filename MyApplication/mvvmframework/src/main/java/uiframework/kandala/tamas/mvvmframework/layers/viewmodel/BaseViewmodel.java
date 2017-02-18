package uiframework.kandala.tamas.mvvmframework.layers.viewmodel;

import android.databinding.BaseObservable;

import uiframework.kandala.tamas.mvvmframework.layers.view.IViewBinder;


public class BaseViewmodel<V extends IViewBinder> extends BaseObservable {

    protected V binder;

    public void attachViewBinder(V view) {
        this.binder = view;
    }

    public void detachViewBinder() {
        this.binder = null;
    }
}
