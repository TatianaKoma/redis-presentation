package com.example.redispresentation.controller;
import com.example.redispresentation.model.Person;
import com.example.redispresentation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersones() {
        return ResponseEntity.ok(personService.getAllPersones());
    }

    @GetMapping("/{personId}")
    public Person getOnePerson(@PathVariable("personId") Integer personId) {
        return personService.getOnePerson(personId);
    }

    @PutMapping("/{personId}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("personId") Integer personId) {
        return personService.updatePerson(person,personId);
    }

    @DeleteMapping("/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {
        personService.deletePerson(personId);
        return "Person with id: " + personId + " Deleted !";
    }
}
