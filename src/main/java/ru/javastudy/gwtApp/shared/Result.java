package ru.javastudy.gwtApp.shared;

import java.io.Serializable;

public class Result implements Serializable {
    private Double order_one;
    private Double order_max;
    private Double order_itog;

    public Result()  {
    }

    public Double getOrder_one() {
        return order_one;
    }

    public void setOrder_one(Double order_one) {
        this.order_one = order_one;
    }

    public Double getOrder_max() {
        return order_max;
    }

    public void setOrder_max(Double order_max) {
        this.order_max = order_max;
    }

    public Double getOrder_itog() {
        return order_itog;
    }

    public void setOrder_itog(Double order_itog) {
        this.order_itog = order_itog;
    }
}
