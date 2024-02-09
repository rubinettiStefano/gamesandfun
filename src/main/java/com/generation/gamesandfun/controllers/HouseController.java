package com.generation.gamesandfun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesandfun.model.entities.House;
import com.generation.gamesandfun.model.repositories.HouseRepository;


@RestController
public class HouseController 
{
    @Autowired
    HouseRepository repo;

    @GetMapping("/houses")
    public List<House> getMethodName() {
        return repo.findAll();
    }
    
}
