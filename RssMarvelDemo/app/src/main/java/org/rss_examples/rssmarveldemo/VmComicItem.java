package org.rss_examples.rssmarveldemo;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.karumi.marvelapiclient.model.ComicDto;

public class VmComicItem extends BaseObservable {

    public ObservableField<String> url = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> description = new ObservableField<>("");

    public VmComicItem(ComicDto data) {
        if (data.getImages() != null && data.getImages().size() > 0) {
            url.set(data.getImages().get(0).getPath());
        }
        title.set(data.getTitle());
        description.set(data.getDescription());
    }
}
