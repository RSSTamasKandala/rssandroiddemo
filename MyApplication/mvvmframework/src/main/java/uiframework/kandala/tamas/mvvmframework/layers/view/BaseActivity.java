package uiframework.kandala.tamas.mvvmframework.layers.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by FlashBook on 18/02/2017.
 */

public abstract class BaseActivity<V extends BaseViewBinder> extends AppCompatActivity {

    protected V viewBinder;

    protected abstract int getLayoutId();

    public abstract V getViewBinder();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        viewBinder.bindView(DataBindingUtil.setContentView(this, getLayoutId()));

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewBinder.reBindView();
    }

    @Override
    protected void onPause() {
        viewBinder.unBindView();
        super.onPause();
    }
}
