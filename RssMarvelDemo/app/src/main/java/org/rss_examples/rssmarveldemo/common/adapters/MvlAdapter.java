package org.rss_examples.rssmarveldemo.common.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.superclasses.RecycleBindingVHolder;
import org.rss_examples.rssmarveldemo.common.view.ProgressItemView;

import java.util.ArrayList;
import java.util.List;

public class MvlAdapter extends RecyclerView.Adapter<RecycleBindingVHolder> {

    private List<IMvlItemView> itemViews = new ArrayList<>();

    public void setItemViews(List<IMvlItemView> itemViews) {
        this.itemViews.addAll(itemViews);
        notifyDataSetChanged();
    }

    public void addItemView(IMvlItemView itemViews) {
        this.itemViews.add(itemViews);
        notifyItemInserted(this.itemViews.size() - 1);
    }

    @Override
    public RecycleBindingVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleBindingVHolder<>(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), viewType, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(RecycleBindingVHolder holder, int position) {
        itemViews.get(position).onBindView(holder);
        holder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemViews.get(position).getLayoutId();
    }

    public IMvlItemView getItemView(int position) {
        return itemViews.get(position);
    }

    public void showProgress() {
        if(itemViews.size()>0) {
            int lastItem = itemViews.size() - 1;
            if (!(itemViews.get(lastItem) instanceof ProgressItemView)) {
                itemViews.add(new ProgressItemView());
                notifyItemInserted(itemViews.size() - 1);
            }
        }
    }

    public void hideProgress() {
        if (!itemViews.isEmpty()) {
            int lastItem = itemViews.size() - 1;
            if (itemViews.get(lastItem) instanceof ProgressItemView) {
                itemViews.remove(lastItem);
                notifyItemRemoved(lastItem);
            }
        }
    }

    public void addItemViews(List<IMvlItemView> list) {
        int startPosition = this.itemViews.size();
        this.itemViews.addAll(list);
        notifyItemRangeInserted(startPosition, itemViews.size());
    }
}
