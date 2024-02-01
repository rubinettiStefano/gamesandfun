package com.generation.gamesandfun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.repositories.PersonRepository;

@SpringBootTest
class GamesandfunApplicationTests {

	@Autowired
	PersonRepository repo;

	@Test
	void contextLoads() 
	{
		System.out.println(repo.findAll());
	}

}
