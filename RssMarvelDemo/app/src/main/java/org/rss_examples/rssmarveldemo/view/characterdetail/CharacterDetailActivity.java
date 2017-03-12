package org.rss_examples.rssmarveldemo.view.characterdetail;

import android.content.Context;
import android.content.Intent;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;



public class CharacterDetailActivity extends MvlActivity {

    private static final String EXTRA_CHARACTER_ID = "character_id";

    public static void startActivity(Context context, String characterID) {
        Intent intent = new Intent(context, CharacterDetailActivity.class);
        intent.putExtra(CharacterDetailActivity.EXTRA_CHARACTER_ID, characterID);
        //TODO remove comment after activity implemented
        //context.startActivity(intent);
    }

    @Override
    public void bindUI() {

    }
}
