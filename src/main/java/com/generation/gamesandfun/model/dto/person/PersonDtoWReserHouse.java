package com.generation.gamesandfun.model.dto.person;

import java.util.List;

import com.generation.gamesandfun.model.dto.reservation.ReservationDtoWHouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonDtoWReserHouse extends PersonDtoBase
{
    private Integer id;
    List<ReservationDtoWHouse> prenotations;
}
