package com.generation.gamesandfun.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesandfun.model.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>
{

    
} 