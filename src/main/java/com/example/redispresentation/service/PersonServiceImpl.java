package com.example.redispresentation.service;

import com.example.redispresentation.PersonNotFoundException;
import com.example.redispresentation.model.Person;
import com.example.redispresentation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    @CachePut(value = "Person", key = "#personId")
    public Person updatePerson(Person newPerson, Integer personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person Not Found"));
        person.setName(newPerson.getName());
        person.setSurname(newPerson.getSurname());
        person.setAge(newPerson.getAge());
        return personRepository.save(person);
    }

    @Override
    @CacheEvict(value = "Person", key = "#personId")
    public void deletePerson(Integer personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person Not Found"));
        personRepository.delete(person);
    }

    @Override
    @Cacheable(value = "Person", key = "#personId")
    public Person getOnePerson(Integer personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person Not Found"));
    }

    @Override
    public List<Person> getAllPersones() {
        return personRepository.findAll();
    }
}
