package com.example.redispresentation.repository;

import com.example.redispresentation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
