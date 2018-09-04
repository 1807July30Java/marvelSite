package com.revature.beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BEEHIVE")
public class Beehive {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beehiveSequence")
    @SequenceGenerator(allocationSize = 1, name = "beehiveSequence", sequenceName = "SQ_BEEHIVE_PK")
    @Column(name = "BEEHIVE_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "WEIGHT")
    private double weight;

    public Beehive(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Beehive(String name, double weight) {
        this.name = name;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beehive beehive = (Beehive) o;
        return getId() == beehive.getId() &&
                Double.compare(beehive.getWeight(), getWeight()) == 0 &&
                Objects.equals(getName(), beehive.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getWeight());
    }

    @Override
    public String toString() {
        return "Beehive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
