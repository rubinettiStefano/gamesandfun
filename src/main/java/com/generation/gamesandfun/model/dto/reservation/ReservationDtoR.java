package com.generation.gamesandfun.model.dto.reservation;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReservationDtoR 
{
    private int price,duration;
    private LocalDate checkin;
    private Integer person_id,house_id;
}
