package org.rss_examples.rssmarveldemo.view.comicdetail;

import android.content.Context;
import android.content.Intent;

import org.rss_examples.rssmarveldemo.common.superclasses.MvlActivity;

/**
 * Created by FlashBook on 12/03/2017.
 */

public class ComicDetailActivity extends MvlActivity {

    private static final String EXTRA_COMIC_ID="comic_id";

    public static void startActivity(Context context,String comicId){
        Intent intent = new Intent(context, ComicDetailActivity.class);
        intent.putExtra(ComicDetailActivity.EXTRA_COMIC_ID,comicId);
        //TODO remove comment after activity implemented
       // context.startActivity(intent);
    }

    @Override
    public void bindUI() {

    }
}
