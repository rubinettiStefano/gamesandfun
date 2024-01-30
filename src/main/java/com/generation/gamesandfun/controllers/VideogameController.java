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

import com.generation.gamesandfun.model.entities.SoftwareHouse;
import com.generation.gamesandfun.model.entities.Videogame;
import com.generation.gamesandfun.model.repositories.SoftwareHouseRepository;
import com.generation.gamesandfun.model.repositories.VideogameRepository;


public class VideogameController 
{
    @Autowired
    VideogameRepository repo;
    @Autowired
    SoftwareHouseRepository repoSh;

    @GetMapping("/videogames")
    public List<Videogame> getAll() 
    {
        return repo.findAll();
    }

    @GetMapping("/videogames/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) 
    {
        Optional<Videogame> op = repo.findById(id);

        if(op.isPresent())
            return new ResponseEntity<Videogame>(op.get(),HttpStatus.OK);
        else
            return new ResponseEntity<String>("No videogame with id "+id,HttpStatus.NOT_FOUND);
    }
    

    @PostMapping("/videogames/{id_sh}")
    public ResponseEntity<?> insert(@PathVariable Integer id_sh,@RequestBody Videogame entity) 
    {
        Optional<SoftwareHouse> op = repoSh.findById(id_sh);   
        if(op.isEmpty())
            return new ResponseEntity<String>("No software house with id "+id_sh,HttpStatus.NOT_FOUND); 
            
        SoftwareHouse sh = op.get();
        entity.setSoftware_house(sh);
        return new ResponseEntity<Videogame>(repo.save(entity),HttpStatus.OK);
    }

    @PutMapping("/videogames/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Videogame entity) 
    {
        Optional<Videogame> op = repo.findById(id);
        if(op.isPresent())
        {
            entity.setId(id);
            return new ResponseEntity<Videogame>(repo.save(entity),HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("No videogame with id "+id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/videogames/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id,@RequestBody Videogame entity) 
    {
        Optional<Videogame> op = repo.findById(id);
        if(op.isPresent())
        {
            return new ResponseEntity<String>("",HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("No svideogame with id "+id,HttpStatus.NOT_FOUND);
    }
}
