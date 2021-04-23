package ru.javastudy.gwtApp.client;
/* ShOleg  22.04.2021*/

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.javastudy.gwtApp.shared.Result;
import ru.javastudy.gwtApp.shared.Result01;
import java.util.List;

public class GwtApp implements EntryPoint {

    final Button confirmButton = new Button("Получить результат");
    final TextBox fldR0 = new TextBox();
    final TextBox fldR1 = new TextBox();
    final TextBox fldR2 = new TextBox();
    final TextBox fldR3 = new TextBox();
    final TextBox fldR4 = new TextBox();
    final TextBox fldR5 = new TextBox();
    final TextBox fldR6= new TextBox();
    final TextBox fldR7 = new TextBox();
    final TextBox fldR8 = new TextBox();

    final TextBox fldR00 = new TextBox();
    final TextBox fldR10 = new TextBox();
    final TextBox fldR20 = new TextBox();
    final TextBox fldR30 = new TextBox();
    final TextBox fldR40 = new TextBox();
    final TextBox fldR50 = new TextBox();

    final Label helloLabel = new Label();

    private final GwtAppServiceAsync gwtAppService = GWT.create(GwtAppService.class);

    /** This is the entry point method.*/
    public void onModuleLoad() {

        helloLabel.setText("Привет Магнит !!!!");

        final Label usernameLabel = new Label();
        usernameLabel.setText("Username: ");
        /*Связываем id='' на html странице с компонентами */
        RootPanel.get("helloId").add(helloLabel);

        fldR0.setWidth("250px");
        fldR1.setWidth("250px");
        fldR2.setWidth("250px");
        fldR3.setWidth("250px");
        fldR4.setWidth("250px");
        fldR5.setWidth("250px");
        fldR6.setWidth("250px");
        fldR7.setWidth("250px");
        fldR8.setWidth("250px");

        fldR00.setWidth("250px");
        fldR10.setWidth("250px");
        fldR20.setWidth("250px");
        fldR30.setWidth("250px");
        fldR40.setWidth("250px");
        fldR50.setWidth("250px");

        RootPanel.get("fldR0").add(fldR0);
        RootPanel.get("fldR1").add(fldR1);
        RootPanel.get("fldR2").add(fldR2);
        RootPanel.get("fldR3").add(fldR3);
        RootPanel.get("fldR4").add(fldR4);
        RootPanel.get("fldR5").add(fldR5);
        RootPanel.get("fldR6").add(fldR6);
        RootPanel.get("fldR7").add(fldR7);
        RootPanel.get("fldR8").add(fldR8);

        RootPanel.get("fldR00").add(fldR00);
        RootPanel.get("fldR10").add(fldR10);
        RootPanel.get("fldR20").add(fldR20);
        RootPanel.get("fldR30").add(fldR30);
        RootPanel.get("fldR40").add(fldR40);
        RootPanel.get("fldR50").add(fldR50);

        RootPanel.get("confirmButton").add(confirmButton);

        confirmButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                GwtAppServiceAsync rpcService = GWT.create(GwtAppService.class);
                rpcService.getResult(new AsyncCallback<List<Result>>(){
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Fail getAllUsers Result");
                    }
                    @Override
                    public void onSuccess(List<Result> result) {
                        Result r = result.get(0);
                        fldR0.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(1);
                        fldR1.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(2);
                        fldR2.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(3);
                        fldR3.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(4);
                        fldR4.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(5);
                        fldR5.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(6);
                        fldR6.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(7);
                        fldR7.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                        r = result.get(8);
                        fldR8.setText( getFormat(r.getOrder_one()) + " - " + getFormat(r.getOrder_max()) + " - " + getFormat(r.getOrder_itog()));

                    }
                });

                rpcService.getResult01(new AsyncCallback<List<Result01>>(){
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Fail getAllUsers Result01");
                    }
                    @Override
                    public void onSuccess(List<Result01> result) {
                        Result01 r = result.get(0);
                        fldR00.setText( getFormat(r.getRc_id()) + " - " + getFormat(r.getWh_id()) + " - " + getFormat(r.getSred()));
                        r = result.get(1);
                        fldR10.setText( getFormat(r.getRc_id()) + " - " + getFormat(r.getWh_id()) + " - " + getFormat(r.getSred()));
                        r = result.get(2);
                        fldR20.setText( getFormat(r.getRc_id()) + " - " + getFormat(r.getWh_id()) + " - " + getFormat(r.getSred()));
                        r = result.get(3);
                        fldR30.setText( getFormat(r.getRc_id()) + " - " + getFormat(r.getWh_id()) + " - " + getFormat(r.getSred()));
                        r = result.get(4);
                        fldR40.setText( getFormat(r.getRc_id()) + " - " + getFormat(r.getWh_id()) + " - " + getFormat(r.getSred()));
                        r = result.get(5);
                        fldR50.setText( getFormat(r.getRc_id()) + " - " + getFormat(r.getWh_id()) + " - " + getFormat(r.getSred()));
                    }
                });
            }
        });
    }

    private String getFormat(double val){
        return NumberFormat.getFormat("0.0000").format(val);
    }
}
