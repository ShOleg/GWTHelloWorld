package ru.javastudy.gwtApp.shared;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Tabletype implements Serializable {
    private Integer arId;
    private Integer typeId;

    @Basic
    @Column(name = "ar_id", nullable = true)
    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tabletype tabletype = (Tabletype) o;

        if (arId != null ? !arId.equals(tabletype.arId) : tabletype.arId != null) return false;
        if (typeId != null ? !typeId.equals(tabletype.typeId) : tabletype.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = arId != null ? arId.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        return result;
    }
}
