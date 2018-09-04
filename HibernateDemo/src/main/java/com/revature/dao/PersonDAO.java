package com.revature.dao;

import com.revature.beans.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getPeople();
    Person getPerson(int personID);
    int addPerson(Person p);
    void updatePerson(Person p);
    void deletePerson(Person p);
}
