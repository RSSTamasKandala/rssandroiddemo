package org.rss_examples.rssmarveldemo.data;

import android.support.annotation.WorkerThread;

import com.karumi.marvelapiclient.CharacterApiClient;
import com.karumi.marvelapiclient.ComicApiClient;
import com.karumi.marvelapiclient.MarvelApiConfig;
import com.karumi.marvelapiclient.MarvelApiException;
import com.karumi.marvelapiclient.model.CharacterDto;
import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.CharactersQuery;
import com.karumi.marvelapiclient.model.ComicDto;
import com.karumi.marvelapiclient.model.ComicsDto;
import com.karumi.marvelapiclient.model.ComicsQuery;
import com.karumi.marvelapiclient.model.MarvelResponse;

import org.rss_examples.rssmarveldemo.common.utils.RestError;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MarvelRepository implements IMarvelRepository {

    private static final String PUBLIC_KEY = "fa953fb06895ce64c1585fd8f577482e";
    private static final String PRIVATE_KEY = "20214c56c461fb07c3e4aa8d257e4d7da2d7b277";
    private static final int SUCCESS_CODE = 200;
    private static MarvelRepository instance;
    private final CharacterApiClient characterApiClient;
    private final ComicApiClient comicApiClient;

    private MarvelRepository() {
        MarvelApiConfig marvelApiConfig = new MarvelApiConfig.Builder(PUBLIC_KEY, PRIVATE_KEY).debug().build();
        characterApiClient = new CharacterApiClient(marvelApiConfig);
        comicApiClient = new ComicApiClient(marvelApiConfig);
    }

    public synchronized static MarvelRepository getInstance() {
        if (instance == null) {
            instance = new MarvelRepository();
        }
        return instance;
    }

    @WorkerThread
    @Override
    public Observable<CharactersDto> getCharactersList(final int skip, final int limit) {
        return Observable
                .fromCallable(new Callable<CharactersDto>() {
                    @Override
                    public CharactersDto call() throws Exception {
                        CharactersQuery query = CharactersQuery.Builder.create().withOffset(skip).withLimit(limit).build();
                        MarvelResponse<CharactersDto> all = characterApiClient.getAll(query);
                        if (all.getCode() == SUCCESS_CODE) {
                            return all.getResponse();
                        } else {
                            throw new RestError(all.getCode());
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @WorkerThread
    @Override
    public Observable<ComicsDto> getComicList(final int skip, final int limit) {
        return Observable
                .fromCallable(new Callable<ComicsDto>() {
                    @Override
                    public ComicsDto call() throws Exception {
                        ComicsQuery query = ComicsQuery.Builder.create().withOffset(skip).withLimit(limit).build();
                        MarvelResponse<ComicsDto> all = comicApiClient.getAll(query);
                        if (all.getCode() == SUCCESS_CODE) {
                            return all.getResponse();
                        } else {
                            throw new RestError(all.getCode());
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @WorkerThread
    @Override
    public Observable<CharacterDto> getCharacter(final String id) {
        return Observable
                .fromCallable(new Callable<CharacterDto>() {
                    @Override
                    public CharacterDto call() throws Exception {
                        MarvelResponse<CharacterDto> response = characterApiClient.getCharacter(id);
                        if (response.getCode() == SUCCESS_CODE) {
                            return response.getResponse();
                        } else {
                            throw new RestError(response.getCode());
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @WorkerThread
    @Override
    public Observable<ComicDto> getComic(final String id) {
        return Observable
                .fromCallable(new Callable<ComicDto>() {
                    @Override
                    public ComicDto call() throws Exception {
                        MarvelResponse<ComicDto> response = comicApiClient.getComic(id);
                        if (response.getCode() == SUCCESS_CODE) {
                            return response.getResponse();
                        } else {
                            throw new RestError(response.getCode());
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @WorkerThread
    @Override
    public Observable<ComicsDto> getComicListByCharacter(final int characterId, final int skip, final int limit) {
        return Observable
                .fromCallable(new Callable<ComicsDto>() {
                    @Override
                    public ComicsDto call() throws Exception {
                        ComicsQuery query = ComicsQuery.Builder.create().addCharacter(characterId).withOffset(skip).withLimit(limit).build();
                        MarvelResponse<ComicsDto> all = comicApiClient.getAll(query);
                        if (all.getCode() == SUCCESS_CODE) {
                            return all.getResponse();
                        } else {
                            throw new RestError(all.getCode());
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @WorkerThread
    @Override
    public Observable<CharactersDto> getCharacterListByComic(final int skip, final int limit, final int comicId) {
        return Observable
                .fromCallable(new Callable<CharactersDto>() {
                    @Override
                    public CharactersDto call() throws Exception {
                        CharactersQuery query = CharactersQuery.Builder.create().
                                addComic(comicId)
                                .withLimit(limit)
                                .withOffset(skip)
                                .build();

                        try {
                            MarvelResponse<CharactersDto> all = characterApiClient.getAll(query);
                            if (all.getCode() == SUCCESS_CODE) {
                                return all.getResponse();
                            } else {
                                throw new RestError(all.getCode());
                            }
                        } catch (MarvelApiException e) {
                            throw new RestError(e.getHttpCode());
                        }


                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
