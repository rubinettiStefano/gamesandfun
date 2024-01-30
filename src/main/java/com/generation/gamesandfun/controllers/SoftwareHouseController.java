package com.generation.gamesandfun.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesandfun.model.entities.SoftwareHouse;
import com.generation.gamesandfun.model.repositories.SoftwareHouseRepository;



@RestController
public class SoftwareHouseController 
{
    @Autowired
    SoftwareHouseRepository repo;

    @GetMapping("/softwarehouses")
    public List<SoftwareHouse> getAll() 
    {
        return repo.findAll();
    }

    @GetMapping("/softwarehouses/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) 
    {
        Optional<SoftwareHouse> op = repo.findById(id);

        if(op.isPresent())
            return new ResponseEntity<SoftwareHouse>(op.get(),HttpStatus.OK);
        else
            return new ResponseEntity<String>("No software house with id "+id,HttpStatus.NOT_FOUND);
    }
    

    @PostMapping("/softwarehouses")
    public ResponseEntity<?> insert(@RequestBody SoftwareHouse entity) 
    {
        return new ResponseEntity<SoftwareHouse>(repo.save(entity),HttpStatus.OK);
    }

    @PutMapping("/softwarehouses/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody SoftwareHouse entity) 
    {
        Optional<SoftwareHouse> op = repo.findById(id);
        if(op.isPresent())
        {
            entity.setId(id);
            return new ResponseEntity<SoftwareHouse>(repo.save(entity),HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("No software house with id "+id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/softwarehouses/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id,@RequestBody SoftwareHouse entity) 
    {
        Optional<SoftwareHouse> op = repo.findById(id);
        if(op.isPresent())
        {
            return new ResponseEntity<String>("",HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("No software house with id "+id,HttpStatus.NOT_FOUND);
    }
    
}
