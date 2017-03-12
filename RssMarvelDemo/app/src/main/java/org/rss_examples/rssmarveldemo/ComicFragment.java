package org.rss_examples.rssmarveldemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import org.rss_examples.rssmarveldemo.adapters.ComicAdapter;
import org.rss_examples.rssmarveldemo.common.MvlActivity;
import org.rss_examples.rssmarveldemo.data.IResponseListener;
import org.rss_examples.rssmarveldemo.data.MarvelRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ComicFragment extends Fragment {

    private static final String TAG = "ComicFragment";
    private ComicAdapter comicAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.comic_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.comic_list);

        comicAdapter = new ComicAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(comicAdapter);

//        getComicList();
        getRxComicList();
//        getCharactersList();
        
        return root;
    }

    private void getRxComicList() {
        MarvelRepository.getInstance()
                .getComicList(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComicsDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(getActivity(), "getRxComicList Started", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ComicsDto value) {
                        proccessComicResponse(value);
                        for (ComicDto comic : value.getComics()) {
                            comicAdapter.addItemView(new ComicItem(new VmComicItem(comic)));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(getActivity(), "getRxComicList Complete", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    protected void getComicList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MarvelRepository.getInstance().getComicList(0, 10, new IResponseListener<ComicsDto>() {
                    @Override
                    public void onResponse(final ComicsDto object) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                proccessComicResponse(object);
                            }
                        });
                    }
                }, ((MvlActivity)getActivity()).errorListener);
            }
        }).start();
    }

    protected void getCharactersList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MarvelRepository.getInstance().getCharactersList(0, 10, new IResponseListener<CharactersDto>() {
                    @Override
                    public void onResponse(final CharactersDto object) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                proccessCharactersResponse(object);
                            }
                        });
                    }
                }, ((MvlActivity)getActivity()).errorListener);
            }
        }).start();
    }

    protected void proccessCharactersResponse(CharactersDto object) {
        for (CharacterDto charactersDto : object.getCharacters()) {
            Log.i(TAG, "proccessCharactersResponse: " + charactersDto.toString());
        }
    }

    protected void proccessComicResponse(ComicsDto object) {
        for (ComicDto comicDto : object.getComics()) {
            Log.i(TAG, "proccessComicResponse: " + comicDto.toString());
        }
    }
}
