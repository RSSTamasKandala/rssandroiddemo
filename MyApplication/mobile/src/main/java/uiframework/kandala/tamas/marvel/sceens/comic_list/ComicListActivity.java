package uiframework.kandala.tamas.marvel.sceens.comic_list;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import uiframework.kandala.tamas.mvvmframework.layers.view.BaseActivity;

/**
 * Created by FlashBook on 18/02/2017.
 */
@EActivity
public class ComicListActivity extends BaseActivity<ComicListBinder> {
    @Bean
    ComicListBinder binder;

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public ComicListBinder getViewBinder() {
        return binder;
    }
}
