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
import com.generation.gamesandfun.model.dto.person.PersonDtoWReserHouse;
import com.generation.gamesandfun.model.dto.person.PersonDtoWWithHouses;
import com.generation.gamesandfun.model.dto.person.PersonDtoWWithReservations;
import com.generation.gamesandfun.model.dto.person.PersonDtoWWithSuperReservation;
import com.generation.gamesandfun.model.dtoservices.PersonConverter;
import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.repositories.PersonRepository;
import org.springframework.web.bind.annotation.RequestParam;



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

    @GetMapping("/people/{id}")
    public PersonDtoWFull getMethodName(@PathVariable Integer id) {
        return conv.personToDtoWFull(repo.findById(id).get());
    }

    @GetMapping("/people/{id}/houses")
    public PersonDtoWWithHouses getPersonWithHouses(@PathVariable Integer id) {
        return conv.personToDtoWWithHouses(repo.findById(id).get());
    }

    @GetMapping("/people/{id}/reservations")
    public PersonDtoWWithReservations getPersonWithReservations(@PathVariable Integer id) {
        return conv.personToDtoWWithReservations(repo.findById(id).get());
    }

    @GetMapping("/people/{id}/prenotations")
    public PersonDtoWReserHouse getPPersonDtoWReserHouse(@PathVariable Integer id) {
        return conv.personToDtoWReserHouse(repo.findById(id).get());
    }

    @GetMapping("/people/{id}/reservationsaug")
    public PersonDtoWWithSuperReservation getPersonWithReservationsAugmented(@PathVariable Integer id) {
        return conv.personToDtoWWithSuperReservation(repo.findById(id).get());
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
