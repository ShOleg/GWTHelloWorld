package ru.javastudy.gwtApp.shared;

import java.io.Serializable;

public class Result01 implements Serializable {
    private Double rc_id;
    private Double wh_id;
    private Double sred;

    public Result01() {
    }

    public Double getRc_id() {
        return rc_id;
    }

    public void setRc_id(Double rc_id) {
        this.rc_id = rc_id;
    }

    public Double getWh_id() {
        return wh_id;
    }

    public void setWh_id(Double wh_id) {
        this.wh_id = wh_id;
    }

    public Double getSred() {
        return sred;
    }

    public void setSred(Double sred) {
        this.sred = sred;
    }
}
