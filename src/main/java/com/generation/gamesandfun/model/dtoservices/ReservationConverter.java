package com.generation.gamesandfun.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.gamesandfun.model.dto.reservation.ReservationDtoWaugmented;
import com.generation.gamesandfun.model.entities.Reservation;
import com.generation.gamesandfun.model.repositories.ReservationRepository;
@Service
public class ReservationConverter 
{
     @Autowired
    ReservationRepository repo;

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

    public String calcHouseLocation(Reservation e)
    {
        return e.getHouse().getAddress() + ", "+ e.getHouse().getCity();
    }
}
