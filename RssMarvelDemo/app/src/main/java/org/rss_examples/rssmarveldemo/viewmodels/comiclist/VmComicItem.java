package org.rss_examples.rssmarveldemo.viewmodels.comiclist;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.karumi.marvelapiclient.model.ComicDto;

public class VmComicItem extends BaseObservable {

    public ObservableField<String> url;
    public ObservableField<String> title;
    public ObservableField<String> description;

    public VmComicItem(ComicDto data) {
        url = new ObservableField<>("");
        title = new ObservableField<>("");
        description = new ObservableField<>("");
        if (data.getThumbnail() != null) {
            url.set(data.getThumbnail().getPath() + "." + data.getThumbnail().getExtension());
        }
        title.set(data.getTitle());
        description.set(data.getDescription());
    }
}
