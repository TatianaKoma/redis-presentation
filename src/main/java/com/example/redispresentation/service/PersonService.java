package com.example.redispresentation.service;

import com.example.redispresentation.model.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);

    Person updatePerson(Person person, Integer personId);

    void deletePerson(Integer personId);

    Person getOnePerson(Integer personId);

    List<Person> getAllPersones();

}
