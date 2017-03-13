package org.rss_examples.rssmarveldemo.data;

import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;

import io.reactivex.Observable;
import io.reactivex.Observer;


interface IMarvelRepository {


    Observable<CharactersDto> getCharactersList(int skip, int limit);

    Observable<ComicsDto> getComicList(int skip, int limit);

    Observable<CharacterDto> getCharacter(String id);

    Observable<ComicDto> getComic(String id);

}
