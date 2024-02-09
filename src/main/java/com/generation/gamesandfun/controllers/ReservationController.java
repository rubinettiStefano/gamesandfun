package com.generation.gamesandfun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesandfun.model.dto.reservation.ReservationDtoR;
import com.generation.gamesandfun.model.dtoservices.ReservationConverter;
import com.generation.gamesandfun.model.entities.Reservation;
import com.generation.gamesandfun.model.repositories.ReservationRepository;


@RestController
public class ReservationController
{

    @Autowired
    ReservationConverter conv;
    @Autowired
    ReservationRepository repo;


    @PostMapping("/reservations")
    public void getMethodName(@RequestBody ReservationDtoR dto) {
        repo.save(conv.dtoRToReservation(dto));
    }
    
}
