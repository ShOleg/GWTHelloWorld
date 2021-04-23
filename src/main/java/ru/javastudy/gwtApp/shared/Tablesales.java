package ru.javastudy.gwtApp.shared;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Tablesales implements Serializable {
    private Integer rcId;
    private Integer arId;
    private Integer whId;
    private Double sales;

    @Basic
    @Column(name = "rc_id", nullable = true)
    public Integer getRcId() {
        return rcId;
    }

    public void setRcId(Integer rcId) {
        this.rcId = rcId;
    }

    @Basic
    @Column(name = "ar_id", nullable = true)
    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    @Basic
    @Column(name = "wh_id", nullable = true)
    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    @Basic
    @Column(name = "sales", nullable = true, precision = 0)
    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablesales that = (Tablesales) o;

        if (rcId != null ? !rcId.equals(that.rcId) : that.rcId != null) return false;
        if (arId != null ? !arId.equals(that.arId) : that.arId != null) return false;
        if (whId != null ? !whId.equals(that.whId) : that.whId != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rcId != null ? rcId.hashCode() : 0;
        result = 31 * result + (arId != null ? arId.hashCode() : 0);
        result = 31 * result + (whId != null ? whId.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
    }
}
