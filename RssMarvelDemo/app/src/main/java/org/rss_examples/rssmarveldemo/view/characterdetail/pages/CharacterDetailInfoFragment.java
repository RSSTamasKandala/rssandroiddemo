package org.rss_examples.rssmarveldemo.view.characterdetail.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rss_examples.rssmarveldemo.R;

public class CharacterDetailInfoFragment extends Fragment {

    private String text;
    public TextView textView;

    public static CharacterDetailInfoFragment createWithText(String text) {
        CharacterDetailInfoFragment characterDetailInfoFragment = new CharacterDetailInfoFragment();
        characterDetailInfoFragment.text = text;
        return characterDetailInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.character_detail_page_fragment, container, false);

        textView = (TextView) root.findViewById(R.id.character_detail_page_text);
        textView.setText(text);

        return root;
    }
}
