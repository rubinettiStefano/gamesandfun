package com.generation.gamesandfun.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesandfun.model.entities.House;

public interface HouseRepository extends JpaRepository<House,Integer>{

}
