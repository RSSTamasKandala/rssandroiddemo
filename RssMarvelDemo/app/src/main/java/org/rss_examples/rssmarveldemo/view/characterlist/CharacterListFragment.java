package org.rss_examples.rssmarveldemo.view.characterlist;

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
import org.rss_examples.rssmarveldemo.common.listeners.LazyLoadingScrollListener;
import org.rss_examples.rssmarveldemo.common.superclasses.MvlFragment;
import org.rss_examples.rssmarveldemo.contracts.CharacterListContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterListBinding;
import org.rss_examples.rssmarveldemo.viewmodels.characterlist.VmCharacterList;

import java.util.List;

public class CharacterListFragment extends MvlFragment implements CharacterListContract.ICharacterListView, LazyLoadingScrollListener.OnLazyLoadingListener {

    private CharacterListBinding binding;
    private MvlAdapter adapter;
    private VmCharacterList viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.character_list,
                container,
                true);

        bindUI();
        return binding.getRoot();
    }

    @Override
    public void bindUI() {
        viewModel = new VmCharacterList();
        viewModel.setView(this);
        binding.setViewmodel(viewModel);
        binding.characterlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MvlAdapter();
        binding.characterlist.setAdapter(adapter);
        binding.characterlist.addOnScrollListener(new LazyLoadingScrollListener(this));

    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.getCharacterList(0);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewModel.unSubscribe();
    }

    @Override
    public void showList(List<IMvlItemView> list) {
        adapter.setItemViews(list);
    }

    @Override
    public void addList(List<IMvlItemView> list) {
        adapter.hideProgress();
        adapter.addItemViews(list);
    }

    @Override
    public void onLazyLoading(int lastItem) {
        adapter.showProgress();
        viewModel.getCharacterList(lastItem);
    }
}
