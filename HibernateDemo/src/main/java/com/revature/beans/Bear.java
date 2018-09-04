package com.revature.beans;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@NamedQueries(
        {
                @NamedQuery(name = "findBearsByType", query = "from Bear where bearType = :typeVar")
        }
)

@Entity
@Table(name = "BEAR")
public class Bear {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bearSequence")
    @SequenceGenerator(allocationSize = 1, name = "bearSequence", sequenceName = "SQ_BEAR_PK")
    @Column(name = "BEAR_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CAVE_ID")
    private Cave cave;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BEAR_TYPE_ID")
    private BearType bearType;
    @Column(name = "WEIGHT")
    private int weight;
    @Column(name = "BIRTHDATE")
    private LocalDate birthdate;

    public Bear() {
    }

    public Bear(String name, Cave cave, BearType bearType, int weight, LocalDate birthdate) {
        this.name = name;
        this.cave = cave;
        this.bearType = bearType;
        this.weight = weight;
        this.birthdate = birthdate;
    }

    public Bear(int id, String name, Cave cave, BearType bearType, int weight, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.cave = cave;
        this.bearType = bearType;
        this.weight = weight;
        this.birthdate = birthdate;
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

    public Cave getCave() {
        return cave;
    }

    public void setCave(Cave cave) {
        this.cave = cave;
    }

    public BearType getBearType() {
        return bearType;
    }

    public void setBearType(BearType bearType) {
        this.bearType = bearType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bear bear = (Bear) o;
        return getId() == bear.getId() &&
                getWeight() == bear.getWeight() &&
                Objects.equals(getName(), bear.getName()) &&
                Objects.equals(getCave(), bear.getCave()) &&
                Objects.equals(getBearType(), bear.getBearType()) &&
                Objects.equals(getBirthdate(), bear.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCave(), getBearType(), getWeight(), getBirthdate());
    }

    @Override
    public String toString() {
        return "Bear{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cave=" + cave +
                ", bearType=" + bearType +
                ", weight=" + weight +
                ", birthdate=" + birthdate +
                '}';
    }
}
