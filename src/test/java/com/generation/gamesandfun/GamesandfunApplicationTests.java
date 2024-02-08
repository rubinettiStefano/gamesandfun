package com.generation.gamesandfun;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.gamesandfun.model.entities.House;
import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.entities.Reservation;
import com.generation.gamesandfun.model.repositories.DocumentRepository;
import com.generation.gamesandfun.model.repositories.HouseRepository;
import com.generation.gamesandfun.model.repositories.PersonRepository;

@SpringBootTest
class GamesandfunApplicationTests {

	@Autowired
	PersonRepository repo;
	@Autowired
	DocumentRepository dRepo;
	@Autowired
	HouseRepository hRepo;

	@Test
	void contextLoads() 
	{
		// Person p = Person.builder()
		// 			.age(28)
		// 			.name("ste")
		// 			.surname("rub")
		// 			.build();
		// p =repo.save(p);

		// Document d1 = Document.builder()
		// 				.expiring_date(LocalDate.now())
		// 				.release_date(LocalDate.now())
		// 				.number("AA")
		// 				.type("PROVA DELETE")
		// 				.owner(p)
		// 				.build();

		// Document d2 = Document.builder()
		// .expiring_date(LocalDate.now())
		// .release_date(LocalDate.now())
		// .number("BB")
		// .type("PROVA DELETE")
		// .owner(p)
		// .build();

		// dRepo.save(d1);
		// dRepo.save(d2);

		// Person stefano = repo.findById(13).get();
		
		// List<Reservation> miePrenotazioni = stefano.getReservations();
		// List<House> caseDoveSonoStato = stefano.getReservations().stream().map(r->r.getHouse()).toList();
		// System.out.println(miePrenotazioni);

		// House casaMilano = hRepo.findById(1).get();

		// List<Person> personeCheSonoStateAMilano = casaMilano.getReservations().stream().map(r->r.getGuest()).toList();
		// System.out.println(miePrenotazioni);

		List<Person> noi = new ArrayList<Person>();

	

		noi.add(Person.builder()
		.name("Irene")
		.surname("Alieksieieva")
		.age(28)
		.build());

		noi.add(Person.builder()
		.name("Maria Rosaria")
		.surname("Casciato")
		.age(29)
		.build());

		noi.add(Person.builder()
		.name("Gaetano")
		.surname("Pierro")
		.age(26)
		.build());

		repo.saveAll(noi);
	}

}
