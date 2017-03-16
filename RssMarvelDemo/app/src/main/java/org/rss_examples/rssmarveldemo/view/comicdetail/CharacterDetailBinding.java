package org.rss_examples.rssmarveldemo.view.comicdetail;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;

/**
 * Created by hsrac on 2017. 03. 16..
 */

public class CharacterDetailBinding {

    @BindingAdapter({"bind:loadCircleCharacterImage"})
    public static void loadCircleCharacterImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.drawable.portrait_placeholder))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleTransform(imageView.getContext()))
                .into(imageView);
    }

}
