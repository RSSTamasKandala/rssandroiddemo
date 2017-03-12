package org.rss_examples.rssmarveldemo.data;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import io.reactivex.Observable;

/**
 * Created by Rss_Kandala on 2017. 02. 14..
 */
public interface IMarvelRepository {


    void getCharactersList(int skip, int limit, IResponseListener<CharactersDto> responseListener, IErrorListener errorListener);

    void getComicList(int skip, int limit, IResponseListener<ComicsDto> responseListener, IErrorListener errorListener);

    Observable getComicList(int skip, int limit);

    void getCharacter(String id, IResponseListener<CharacterDto> responseListener, IErrorListener errorListener);

    void getComic(String id, IResponseListener<ComicDto> responseListener, IErrorListener errorListener);
}
