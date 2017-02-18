package uiframework.kandala.tamas.marveldatalayer.data;

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

    public static MarvelRepository getInstance() {
        if (instance == null) {
            instance = new MarvelRepository();
        }
        return instance;
    }

    @WorkerThread
    @Override
    public void getCharactersList(int skip, int limit, IResponseListener<CharactersDto> responseListener, IErrorListener errorListener) {
        CharactersQuery query = CharactersQuery.Builder.create().withOffset(skip).withLimit(limit).build();
        try {
            MarvelResponse<CharactersDto> all = characterApiClient.getAll(query);
            if (all.getCode() == SUCCESS_CODE) {
                responseListener.onResponse(all.getResponse());
            } else {
                errorListener.onError(errorListener.getRequestFailedMessage(all.getCode()));
            }
        } catch (MarvelApiException e) {
            errorListener.onError(errorListener.getMarvelApiErrorMessage(errorListener.getMarvelApiExceptionCode()));

        }
    }

    @WorkerThread
    @Override
    public void getComicList(int skip, int limit, IResponseListener<ComicsDto> responseListener, IErrorListener errorListener) {
        ComicsQuery query = ComicsQuery.Builder.create().withOffset(skip).withLimit(limit).build();
        try {
            MarvelResponse<ComicsDto> all = comicApiClient.getAll(query);
            if (all.getCode() == SUCCESS_CODE) {
                responseListener.onResponse(all.getResponse());
            } else {
                errorListener.onError(errorListener.getRequestFailedMessage(all.getCode()));
            }
        } catch (MarvelApiException e) {
            errorListener.onError(errorListener.getMarvelApiErrorMessage(errorListener.getMarvelApiExceptionCode()));

        }
    }

    @WorkerThread
    @Override
    public void getCharacter(String id, IResponseListener<CharacterDto> responseListener, IErrorListener errorListener) {
        try {
            MarvelResponse<CharacterDto> response = characterApiClient.getCharacter(id);
            if (response.getCode() == SUCCESS_CODE) {
                responseListener.onResponse(response.getResponse());
            } else {
                errorListener.onError(errorListener.getRequestFailedMessage(response.getCode()));
            }
        } catch (MarvelApiException e) {
            errorListener.onError(errorListener.getMarvelApiErrorMessage(errorListener.getMarvelApiExceptionCode()));

        }

    }

    @WorkerThread
    @Override
    public void getComic(String id, IResponseListener<ComicDto> responseListener, IErrorListener errorListener) {
        try {
            MarvelResponse<ComicDto> response = comicApiClient.getComic(id);
            if (response.getCode() == SUCCESS_CODE) {
                responseListener.onResponse(response.getResponse());
            } else {
                errorListener.onError(errorListener.getRequestFailedMessage(response.getCode()));
            }
        } catch (MarvelApiException e) {
            errorListener.onError(errorListener.getMarvelApiErrorMessage(errorListener.getMarvelApiExceptionCode()));

        }

    }
}
