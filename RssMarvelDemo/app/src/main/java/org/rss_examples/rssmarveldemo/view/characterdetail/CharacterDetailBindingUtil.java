package org.rss_examples.rssmarveldemo.view.characterdetail;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.rss_examples.rssmarveldemo.R;
import org.rss_examples.rssmarveldemo.view.utils.CircleTransform;

public class CharacterDetailBindingUtil {

    @BindingAdapter({"bind:loadCircleImage"})
    public static void loadCircleImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.mipmap.ic_launcher))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @BindingAdapter({"bind:loadSimpleImage"})
    public static void loadSimpleImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.mipmap.ic_launcher))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

}
