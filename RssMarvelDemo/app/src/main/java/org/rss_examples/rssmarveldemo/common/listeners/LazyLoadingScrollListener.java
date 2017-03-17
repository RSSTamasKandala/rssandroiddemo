package org.rss_examples.rssmarveldemo.common.listeners;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.view.ProgressItemView;


public class LazyLoadingScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "LazyLoadingScrollListen";

    public interface OnLazyLoadingListener {
        void onLazyLoading(int lastItem);
    }

    private static final int DEFAULT_THRESHOLD = 10;

    RecyclerView.Adapter adapter;

    Runnable onScrollAction;

    private int lastItemInList = 0;

    private int lazyLoadingThreshold;

    private OnLazyLoadingListener lazyLoadingListener;

    public LazyLoadingScrollListener(OnLazyLoadingListener onLazyLoadingListener) {
        this.adapter = adapter;
        this.lazyLoadingListener = onLazyLoadingListener;
        this.lazyLoadingThreshold = DEFAULT_THRESHOLD;
    }




    public void clearLastItemIndex() {
        this.lastItemInList = 0;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        adapter= recyclerView.getAdapter();
        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        int firstVisibleItem = 0;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        } else if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            int[] position = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPositions(null);
            firstVisibleItem = position[0];
        }

        final int lastItem = firstVisibleItem + visibleItemCount;

        if (lastItem == totalItemCount && lastItemInList != lastItem && adapter.getItemCount() >= lazyLoadingThreshold) {
            lastItemInList = lastItem;
            if (lazyLoadingListener != null) {
                if (adapter instanceof MvlAdapter
                        && ((MvlAdapter) adapter).getItemView(lastItem - 1) instanceof ProgressItemView) {
                    return;
                } else {
                    recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            lazyLoadingListener.onLazyLoading(lastItem);

                        }
                    });
                }

            }
        }
    }


}

