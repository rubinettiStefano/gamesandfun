package com.generation.gamesandfun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/people")
    public Person insertPerson(@RequestBody Person p) {
        return repo.save(p);
    }

    @PutMapping("/people/{id}")
    public Person updatePerson(@RequestBody Person p,@PathVariable Integer id) {
        p.setId(id);
        return repo.save(p);
    }

    @DeleteMapping("/people/{id}")
    public void  deletePerson(@PathVariable Integer id) {
         repo.deleteById(id);
    }
    
}
