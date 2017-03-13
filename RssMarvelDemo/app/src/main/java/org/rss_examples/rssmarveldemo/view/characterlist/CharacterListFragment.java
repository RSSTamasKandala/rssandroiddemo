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
import org.rss_examples.rssmarveldemo.common.superclasses.MvlFragment;
import org.rss_examples.rssmarveldemo.contracts.CharacterListContract;
import org.rss_examples.rssmarveldemo.databinding.CharacterListBinding;
import org.rss_examples.rssmarveldemo.viewmodels.characterlist.VmCharacterList;

import java.util.List;

public class CharacterListFragment extends MvlFragment implements CharacterListContract.ICharacterListView {


    private CharacterListBinding binding;
    private MvlAdapter adapter;


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
        VmCharacterList viewmodel = new VmCharacterList();
        viewmodel.setView(this);
        binding.setViewmodel(viewmodel);
        binding.characterlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MvlAdapter();
        binding.characterlist.setAdapter(adapter);
        viewmodel.getCharacterList();

    }

    @Override
    public void showList(List<IMvlItemView> list) {
        adapter.setItemViews(list);
    }
}
