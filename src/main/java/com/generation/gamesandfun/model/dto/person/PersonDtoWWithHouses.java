package com.generation.gamesandfun.model.dto.person;

import java.util.List;

import com.generation.gamesandfun.model.entities.House;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonDtoWWithHouses extends PersonDtoBase
{
    private Integer id;
    private List<House> houses;
    private int totalSpending;
    private int totalDaysOfVacation;
    private int averageSpending;
    private int averageDaysOfVacation;
    private int averageSpendingPerDay;
}
