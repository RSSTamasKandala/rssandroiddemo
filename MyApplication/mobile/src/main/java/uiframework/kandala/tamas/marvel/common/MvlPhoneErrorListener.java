package uiframework.kandala.tamas.marvel.common;

import org.androidannotations.annotations.EBean;

import uiframework.kandala.tamas.marveldatalayer.data.IErrorListener;

/**
 * Created by FlashBook on 18/02/2017.
 */
@EBean(scope = EBean.Scope.Singleton)
public class MvlPhoneErrorListener implements IErrorListener {
    @Override
    public void onError(String message) {

    }

    @Override
    public String getRequestFailedMessage(int code) {
        return null;
    }

    @Override
    public String getMarvelApiErrorMessage(int code) {
        return null;
    }

    @Override
    public int getMarvelApiExceptionCode() {
        return 0;
    }
}
