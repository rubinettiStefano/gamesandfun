package com.generation.gamesandfun.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.gamesandfun.model.dto.reservation.ReservationDtoR;
import com.generation.gamesandfun.model.dto.reservation.ReservationDtoWHouse;
import com.generation.gamesandfun.model.dto.reservation.ReservationDtoWaugmented;
import com.generation.gamesandfun.model.entities.Reservation;
import com.generation.gamesandfun.model.repositories.HouseRepository;
import com.generation.gamesandfun.model.repositories.PersonRepository;
import com.generation.gamesandfun.model.repositories.ReservationRepository;
@Service
public class ReservationConverter 
{
     @Autowired
    ReservationRepository repo;
    @Autowired
    PersonRepository pRepo;
    @Autowired
    HouseRepository hRepo;

    public Reservation dtoRToReservation(ReservationDtoR dto)
    {
        return Reservation.builder()
                .checkin(dto.getCheckin())
                .duration(dto.getDuration())
                .price(dto.getPrice())
                .guest(pRepo.findById(dto.getPerson_id()).get())
                .house(hRepo.findById(dto.getHouse_id()).get())
                .build();
    }


    public ReservationDtoWaugmented reservationToDtoWaugmented(Reservation e)
    {
        return  ReservationDtoWaugmented.builder()
                .id(e.getId())
                .duration(e.getDuration())
                .price(e.getPrice())
                .checkin(e.getCheckin())
                .houseLocation(calcHouseLocation(e))
                .build();
    }

    public ReservationDtoWHouse reservationToDtoWHouse(Reservation e)
    {
        return  ReservationDtoWHouse.builder()
                .id(e.getId())
                .duration(e.getDuration())
                .price(e.getPrice())
                .checkin(e.getCheckin())
                .house_id(e.getHouse().getId())
                .city(e.getHouse().getCity())
                .address(e.getHouse().getAddress())
                .build();
    }

    public String calcHouseLocation(Reservation e)
    {
        return e.getHouse().getAddress() + ", "+ e.getHouse().getCity();
    }
}
