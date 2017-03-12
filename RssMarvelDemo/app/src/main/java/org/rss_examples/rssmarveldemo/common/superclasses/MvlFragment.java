package org.rss_examples.rssmarveldemo.common.superclasses;

import android.support.v4.app.Fragment;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlView;

/**
 * Created by FlashBook on 12/03/2017.
 */

public abstract class MvlFragment extends Fragment implements IMvlView {
    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void showError(String message) {

    }


}
