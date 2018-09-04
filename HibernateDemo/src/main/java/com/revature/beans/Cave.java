package com.revature.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CAVE")
public class Cave implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caveSequence")
    @SequenceGenerator(allocationSize = 1, name = "caveSequence", sequenceName = "SQ_CAVE_PK")
    @Column(name = "CAVE_ID")
    private int id;
    @Column(name = "CAVE_NAME")
    private String name;
    @Column(name = "MAX_BEARS")
    private int maxBears;
    @OneToMany(mappedBy = "cave", fetch = FetchType.LAZY)
    private List<Bear> bears;

    public Cave() {
    }

    public Cave(int id, String name, int maxBears) {
        this.id = id;
        this.name = name;
        this.maxBears = maxBears;
    }

    public Cave(String name, int maxBears) {
        this.name = name;
        this.maxBears = maxBears;
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

    public int getMaxBears() {
        return maxBears;
    }

    public void setMaxBears(int maxBears) {
        this.maxBears = maxBears;
    }

    public List<Bear> getBears() {
        return bears;
    }

    public void setBears(List<Bear> bears) {
        this.bears = bears;
    }

    @Override
    public String toString() {
        return "Cave{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxBears=" + maxBears +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return id == cave.id &&
                maxBears == cave.maxBears &&
                Objects.equals(name, cave.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxBears);
    }
}
