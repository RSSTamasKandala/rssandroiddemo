package uiframework.kandala.tamas.marveldatalayer.data;

public interface IErrorListener {

    void onError(String message);

    String getRequestFailedMessage(int code);

    String getMarvelApiErrorMessage(int code);

    int getMarvelApiExceptionCode();
}
