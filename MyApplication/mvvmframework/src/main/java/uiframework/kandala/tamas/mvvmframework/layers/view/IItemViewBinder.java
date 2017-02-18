package uiframework.kandala.tamas.mvvmframework.layers.view;

import android.databinding.ViewDataBinding;

/**
 * Created by FlashBook on 18/02/2017.
 */

public interface IItemViewBinder<Binding extends ViewDataBinding> extends IViewBinder {

    int getLayoutId();

    void onBind(Binding binding);
}
