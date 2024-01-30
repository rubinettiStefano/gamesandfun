package com.generation.gamesandfun.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesandfun.model.entities.Videogame;

public interface VideogameRepository extends JpaRepository<Videogame,Integer>
{

}
