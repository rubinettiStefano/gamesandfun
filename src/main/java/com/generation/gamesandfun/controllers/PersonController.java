package com.generation.gamesandfun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.repositories.PersonRepository;


@RestController
public class PersonController 
{
    @Autowired
    PersonRepository repo;

    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return repo.findAll();
    }
    
}
