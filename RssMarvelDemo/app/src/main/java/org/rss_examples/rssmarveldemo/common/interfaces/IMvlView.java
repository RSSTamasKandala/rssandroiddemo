package org.rss_examples.rssmarveldemo.common.interfaces;


public interface IMvlView {

    void showLoading(boolean show);

    void showError(String message);

    void bindUI();

}