package org.rss_examples.rssmarveldemo;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class BindingUtil {

    @BindingAdapter({"bind:loadComicImage"})
    public static void loadComicImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.mipmap.ic_launcher))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}