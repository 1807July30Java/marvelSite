package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name = "MARVEL_CHARACTERS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSequence")
    @SequenceGenerator(allocationSize = 1, name = "personSequence", sequenceName = "SQ_PERSON_PK")
    @Column(name = "PERSON_ID")
    private int personID;
    @Column(name = "NAME")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ALIGNMENT_ID")
    private Alignment alignmentID;
}
