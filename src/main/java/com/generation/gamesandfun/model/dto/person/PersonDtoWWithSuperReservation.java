package com.generation.gamesandfun.model.dto.person;

import java.util.List;

import com.generation.gamesandfun.model.dto.reservation.ReservationDtoWaugmented;
import com.generation.gamesandfun.model.entities.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonDtoWWithSuperReservation extends PersonDtoBase
{
     private Integer id;
    private List<ReservationDtoWaugmented> reservations;
}
