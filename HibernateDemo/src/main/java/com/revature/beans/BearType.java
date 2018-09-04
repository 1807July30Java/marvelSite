package com.revature.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BEAR_TYPE")
public class BearType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bearTypeSequence")
    @SequenceGenerator(allocationSize = 1, name = "bearTypeSequence", sequenceName = "SQ_BEAR_TYPE_PK")
    @Column(name = "TYPE_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURVIVAL_PROCEDURE")
    private String survivalProcedure;
    @OneToMany(mappedBy = "bearType", fetch = FetchType.LAZY)
    private List<Bear> bears;

    public BearType() {
    }

    public BearType(String name, String survivalProcedure) {
        this.name = name;
        this.survivalProcedure = survivalProcedure;
    }

    public BearType(int id, String name, String survivalProcedure) {
        this.id = id;
        this.name = name;
        this.survivalProcedure = survivalProcedure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurvivalProcedure() {
        return survivalProcedure;
    }

    public void setSurvivalProcedure(String survivalProcedure) {
        this.survivalProcedure = survivalProcedure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BearType bearType = (BearType) o;
        return getId() == bearType.getId() &&
                Objects.equals(getName(), bearType.getName()) &&
                Objects.equals(getSurvivalProcedure(), bearType.getSurvivalProcedure());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurvivalProcedure());
    }

    @Override
    public String toString() {
        return "BearType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", survivalProcedure='" + survivalProcedure + '\'' +
                '}';
    }
}
