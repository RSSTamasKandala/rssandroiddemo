package uiframework.kandala.tamas.marveldatalayer.data;

public interface IResponseListener<T extends Object> {

    void onResponse(T object);

}
