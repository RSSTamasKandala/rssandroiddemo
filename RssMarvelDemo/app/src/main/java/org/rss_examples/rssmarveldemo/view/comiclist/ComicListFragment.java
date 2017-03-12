package org.rss_examples.rssmarveldemo.view.comiclist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.common.adapters.MvlAdapter;
import org.rss_examples.rssmarveldemo.common.interfaces.IMvlItemView;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlFragment;
import org.rss_examples.rssmarveldemo.contracts.ComicListContract;
import org.rss_examples.rssmarveldemo.databinding.ComicFragmentBinding;
import org.rss_examples.rssmarveldemo.viewmodels.comiclist.VmComicList;

import java.util.List;

public class ComicListFragment extends MvlFragment implements ComicListContract.IComicListView {

    private MvlAdapter comicAdapter;
    private ComicFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.comic_fragment,
                container,
                true);

        bindUI();

        return binding.getRoot();
    }


    @Override
    public void bindUI() {
        comicAdapter = new MvlAdapter();
        VmComicList vmComicList = new VmComicList();
        vmComicList.setView(this);
        binding.setViewmodel(vmComicList);
        binding.comicList.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.comicList.setAdapter(comicAdapter);
        vmComicList.getComicList();

    }

    @Override
    public void showList(List<IMvlItemView> list) {
        comicAdapter.setItemViews(list);

    }
}
