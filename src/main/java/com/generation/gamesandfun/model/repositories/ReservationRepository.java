package com.generation.gamesandfun.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesandfun.model.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>
{

}
