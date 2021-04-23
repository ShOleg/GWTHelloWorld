package ru.javastudy.gwtApp.shared;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Tablevalue implements Serializable {
    private Integer rcId;
    private Integer arId;
    private Integer whId;
    private Integer typeId;
    private Double qnty;
    private Double perc;

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
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "qnty", nullable = true, precision = 0)
    public Double getQnty() {
        return qnty;
    }

    public void setQnty(Double qnty) {
        this.qnty = qnty;
    }

    @Basic
    @Column(name = "perc", nullable = true, precision = 0)
    public Double getPerc() {
        return perc;
    }

    public void setPerc(Double perc) {
        this.perc = perc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablevalue that = (Tablevalue) o;

        if (rcId != null ? !rcId.equals(that.rcId) : that.rcId != null) return false;
        if (arId != null ? !arId.equals(that.arId) : that.arId != null) return false;
        if (whId != null ? !whId.equals(that.whId) : that.whId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (qnty != null ? !qnty.equals(that.qnty) : that.qnty != null) return false;
        if (perc != null ? !perc.equals(that.perc) : that.perc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rcId != null ? rcId.hashCode() : 0;
        result = 31 * result + (arId != null ? arId.hashCode() : 0);
        result = 31 * result + (whId != null ? whId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (qnty != null ? qnty.hashCode() : 0);
        result = 31 * result + (perc != null ? perc.hashCode() : 0);
        return result;
    }
}
