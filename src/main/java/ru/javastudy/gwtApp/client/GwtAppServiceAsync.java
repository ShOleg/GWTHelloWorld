package ru.javastudy.gwtApp.client;
/* ShOleg  22.04.2021*/
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.javastudy.gwtApp.shared.Result;
import ru.javastudy.gwtApp.shared.Result01;
import java.util.List;

public interface GwtAppServiceAsync {
    void getResult(AsyncCallback<List<Result>>  async);
    void getResult01(AsyncCallback<List<Result01>>  async);
}
