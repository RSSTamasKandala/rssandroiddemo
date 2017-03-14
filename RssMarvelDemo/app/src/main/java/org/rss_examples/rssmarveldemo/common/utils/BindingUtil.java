package org.rss_examples.rssmarveldemo.common.utils;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;

public class BindingUtil {

    @BindingAdapter({"bind:loadImage"})
    public static void loadComicImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.mipmap.ic_launcher))
                .bitmapTransform(new CircleTransform(imageView.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}