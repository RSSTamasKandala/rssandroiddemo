package org.rss_examples.rssmarveldemo.data;

import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import io.reactivex.Observer;


interface IMarvelRepository {


    void getCharactersList(int skip, int limit, Observer<CharactersDto> observer);

    void getComicList(int skip, int limit, Observer<ComicsDto> observer);

}
