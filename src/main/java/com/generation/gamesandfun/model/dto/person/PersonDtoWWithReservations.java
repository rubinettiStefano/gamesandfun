package com.generation.gamesandfun.model.dto.person;

import java.util.List;

import com.generation.gamesandfun.model.entities.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonDtoWWithReservations extends PersonDtoBase
 {

    private Integer id;
    private List<Reservation> reservations;

}
