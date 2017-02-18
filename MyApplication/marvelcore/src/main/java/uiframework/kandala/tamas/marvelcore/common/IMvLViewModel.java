package uiframework.kandala.tamas.marvelcore.common;

import uiframework.kandala.tamas.mvvmframework.layers.view.IViewBinder;
import uiframework.kandala.tamas.mvvmframework.layers.viewmodel.IViewModel;


public interface IMvLViewModel<Binder extends IViewBinder> extends IViewModel<Binder> {

    void getData();
}
