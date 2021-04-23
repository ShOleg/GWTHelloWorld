package ru.javastudy.gwtApp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.javastudy.gwtApp.shared.Result;
import ru.javastudy.gwtApp.shared.Result01;
import java.util.List;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("gwtAppService")
public interface GwtAppService extends RemoteService {
    List<Result>  getResult();
    List<Result01>  getResult01();
}
