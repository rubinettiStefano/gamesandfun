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

import com.generation.gamesandfun.model.dto.person.PersonDtoR;
import com.generation.gamesandfun.model.dto.person.PersonDtoWFull;
import com.generation.gamesandfun.model.dto.person.PersonDtoWNoDocuments;
import com.generation.gamesandfun.model.dtoservices.PersonConverter;
import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.repositories.PersonRepository;


@RestController
public class PersonController 
{
    @Autowired
    PersonRepository repo;
    @Autowired
    PersonConverter conv;

    @GetMapping("/people")
    public List<PersonDtoWNoDocuments> getAllPeopleNoDocuments() 
    {
        return repo.findAll()
               .stream()
               .map(e -> conv.personToDtoWNoDocuments(e))
               .toList();
    }

    @GetMapping("/people/full")
    public List<PersonDtoWFull> getAllPeopleFull() 
    {
        return  repo.findAll()
                .stream()
                .map(e -> conv.personToDtoWFull(e))
                .toList();
    }

    @PostMapping("/people") 
    public Person insertPerson(@RequestBody PersonDtoR dto) {
        return repo.save(conv.dtoRToPerson(dto));
    }




    @PutMapping("/people/{id}")
    public PersonDtoWNoDocuments updatePerson(@RequestBody PersonDtoR dto,@PathVariable Integer id) {
        Person p = conv.dtoRToPerson(dto);
        p.setId(id);
        return conv.personToDtoWNoDocuments(repo.save(p));
    }

    @DeleteMapping("/people/{id}")
    public void  deletePerson(@PathVariable Integer id) {
         repo.deleteById(id);
    }
    
}
