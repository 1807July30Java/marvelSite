package com.revature.beans;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ALIGNMENT")
public class Alignment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alignmentSequence")
    @SequenceGenerator(allocationSize = 1, name = "alignmentSequence", sequenceName = "SQ_ALIGNMENT_PK")
    @Column(name = "ALIGNMENT_ID")
    private int alignmentID;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "alignmentID", fetch = FetchType.LAZY)
    private List<Person> people;

    public Alignment() {
    }

    public Alignment(String name) {
        this.name = name;
    }

    public int getAlignmentID() {
        return alignmentID;
    }

    public void setAlignmentID(int alignmentID) {
        this.alignmentID = alignmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alignment alignment = (Alignment) o;
        return getAlignmentID() == alignment.getAlignmentID() &&
                Objects.equals(getName(), alignment.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlignmentID(), getName());
    }


}
