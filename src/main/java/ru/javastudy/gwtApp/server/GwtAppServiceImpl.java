package ru.javastudy.gwtApp.server;
/* ShOleg  22.04.2021*/

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javastudy.gwtApp.client.GwtAppService;
import ru.javastudy.gwtApp.shared.Result;
import ru.javastudy.gwtApp.shared.Result01;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The server-side implementation of the RPC service.
 */
public class GwtAppServiceImpl extends RemoteServiceServlet implements GwtAppService {
    private SessionFactory sessionFactory;
    private Session session;

    public GwtAppServiceImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public List<Result> getResult() {
        String SQL = "Select I.order_one, cast(I.order_max as decimal(6,4)) order_max, " +
                "cast( case when I.type_id = 1 then I.order_max * 1.5 else I.order_max * 0.85 end as decimal(12,4)) order_itog " +
                "from " +
                "    (select Q.rc_id, Q.ar_id, Q.wh_id, Q.ORDER_ONE, Q.qnty, CASE WHEN Q.ORDER_ONE > Q.qnty THEN Q.ORDER_ONE ELSE Q.qnty END order_max, Q.type_id " +
                "    from " +
                "        (select S.rc_id, S.ar_id,  S.wh_id, cast(S.sales * V.perc as decimal(14,4))  ORDER_ONE, V.qnty, V.type_id " +
                "        from public.tablesales S, " +
                "        (select V.ar_id, V.rc_id, V.wh_id, max(V.qnty) as qnty, max(V.perc) as perc, max(T.type_id) type_id from tablevalue V, tabletype T where V.ar_id=T.ar_id  group by V.ar_id, V.rc_id, V.wh_id)  V " +
                "            where S.ar_id = V.ar_id and S.rc_id = V.rc_id and S.wh_id = V.wh_id and S.sales is not null " +
                "        )  Q) I " +
                "order by I.rc_id, I.ar_id, I.wh_id";

        List<Result> usersList = new ArrayList<>();
        Query query =  session.createSQLQuery(SQL);
        List<Object[]> x = query.list();
        for(Object[] y: x){
            Result res = new Result();
            res.setOrder_one(((BigDecimal) y[0]).doubleValue());
            res.setOrder_max(((BigDecimal) y[1]).doubleValue());
            res.setOrder_itog(((BigDecimal) y[2]).doubleValue());

            usersList.add(res);
        }
        return usersList;
    }

    @Override
    public List<Result01>  getResult01() {
        String SQL = "select cast(S.rc_id as decimal(10,4)) rs_id, cast(0 as decimal(10,4)) wh_id, cast( sum(S.sales * V.perc ) / COUNT(S.*) as decimal(6,4)) sred " +
                "from public.tablesales S, " +
                "     (select V.ar_id, V.rc_id, V.wh_id, max(V.qnty) as qnty, max(V.perc) as perc, max(T.type_id) type_id from tablevalue V, tabletype T where V.ar_id=T.ar_id  group by V.ar_id, V.rc_id, V.wh_id)  V " +
                "where S.ar_id = V.ar_id and S.rc_id = V.rc_id and S.wh_id = V.wh_id and S.sales is not null " +
                "group by S.rc_id " +
                "UNION ALL " +
                "    select cast(S.rc_id as decimal(10,4)) rs_id, cast(S.wh_id as decimal(10,4)) wh_id, cast( sum(S.sales * V.perc ) / COUNT(S.*) as decimal(14,4)) sred " +
                "     from public.tablesales S, " +
                "          (select V.ar_id, V.rc_id, V.wh_id, max(V.qnty) as qnty, max(V.perc) as perc, max(T.type_id) type_id from tablevalue V, tabletype T where V.ar_id=T.ar_id  group by V.ar_id, V.rc_id, V.wh_id)  V " +
                "     where S.ar_id = V.ar_id and S.rc_id = V.rc_id and S.wh_id = V.wh_id and S.sales is not null " +
                "     group by S.rc_id, S.wh_id";
        List<Result01> usersList = new ArrayList<>();
        Query query =  session.createSQLQuery(SQL);

        List<Object[]> x = query.list();
        for(Object[] y: x){
            Result01 res = new Result01();
            res.setRc_id(((BigDecimal) y[0]).doubleValue());
            res.setWh_id(((BigDecimal) y[1]).doubleValue());
            res.setSred(((BigDecimal) y[2]).doubleValue());
            usersList.add(res);
        }
        return usersList;
    }
}
