package com.generation.gamesandfun.model.dtoservices;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.gamesandfun.model.dto.person.PersonDtoR;
import com.generation.gamesandfun.model.dto.person.PersonDtoWFull;
import com.generation.gamesandfun.model.dto.person.PersonDtoWNoDocuments;
import com.generation.gamesandfun.model.dto.person.PersonDtoWWithHouses;
import com.generation.gamesandfun.model.dto.person.PersonDtoWWithReservations;
import com.generation.gamesandfun.model.dto.person.PersonDtoWWithSuperReservation;
import com.generation.gamesandfun.model.dto.reservation.ReservationDtoWaugmented;
import com.generation.gamesandfun.model.entities.House;
import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.entities.Reservation;

//@Component
//Beanizza questa classe
//vale a dire crea un oggetto di questa classe
//che mette nell'Application Context
//e la rende quindi AUTOWIRABILE
@Service 
//non fa nulla di diverso a livello pratico, ma fa capire ai programmatori
//che questo è un SERVIZIO, vale a dire una classe che fa un lavoro
//una classe di cui non ci interessa lo stato
public class PersonConverter 
{ 
    //2 metodi per ogni DTO WR
    //uno per convertire DTO in entità   R
    //uno per convertire entità in DTO   W
    @Autowired
    ReservationConverter rConv;


    public Person dtoRToPerson(PersonDtoR dto)//R
    {
        return  Person
                .builder()
                .age(dto.getAge())
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
    }

    public PersonDtoWFull personToDtoWFull(Person e)
    {
        return  PersonDtoWFull
                .builder()
                .name(e.getName())
                .surname(e.getSurname())
                .age(e.getAge())
                .id(e.getId())
                .documents(e.getDocuments())
                .build();
    }

    public PersonDtoWNoDocuments personToDtoWNoDocuments (Person e)
    {
        return  PersonDtoWNoDocuments
                .builder()
                .name(e.getName())
                .surname(e.getSurname())
                .age(e.getAge())
                .id(e.getId())
                .build();
    }

    public PersonDtoWWithReservations personToDtoWWithReservations (Person e)
    {
        return  PersonDtoWWithReservations
                .builder()
                .name(e.getName())
                .surname(e.getSurname())
                .age(e.getAge())
                .id(e.getId())
                .reservations(e.getReservations())
                .build();
    }

    public PersonDtoWWithSuperReservation personToDtoWWithSuperReservation(Person e)
    {
        return  PersonDtoWWithSuperReservation
                .builder()
                .name(e.getName())
                .surname(e.getSurname())
                .age(e.getAge())
                .id(e.getId())
                //.reservations(e.getReservations().stream().map(r->rConv.reservationToDtoWaugmented(r)).toList())
                .reservations(convertToAugmented(e))
                .build();
    }

    public PersonDtoWWithHouses personToDtoWWithHouses (Person e)
    {
        return  PersonDtoWWithHouses
                .builder()
                .name(e.getName())
                .surname(e.getSurname())
                .age(e.getAge())
                .id(e.getId())
                .houses(calcListHouse(e))
                .totalSpending(calcTotalSpending(e))
                .totalDaysOfVacation(calcTotalDaysOfVacation(e))
                .averageSpending(calcAverageSpending(e))
                .averageDaysOfVacation(calcAverageDaysOfVacation(e))
                .averageSpendingPerDay(calcAverageSpendingPerDay(e))
                .build();
    }

    private List<House> calcListHouse(Person p)
    {
        return p.getReservations().stream().map(r->r.getHouse()).toList();
    }

    private List<ReservationDtoWaugmented> convertToAugmented(Person p)
    {
        List<ReservationDtoWaugmented> res = new ArrayList<ReservationDtoWaugmented>();

        for(Reservation r: p.getReservations())
            res.add(rConv.reservationToDtoWaugmented(r));

        return res;
    }

    private int calcTotalSpending(Person p)
    {
        if(p.getReservations()==null)
            return 0;

        int res = 0;
        for(Reservation r: p.getReservations())
            res+=r.getPrice();

        return res;
    }


    private int calcTotalDaysOfVacation(Person p)
    {
        if(p.getReservations()==null)
            return 0;

        int res = 0;
        for(Reservation r: p.getReservations())
            res+=r.getDuration();

        return res;
    }

    private int calcAverageSpending(Person p)
    {
        if(p.getReservations()==null)
            return 0;
        int total = calcTotalSpending(p);

        return total/p.getReservations().size();
    }

    private int calcAverageDaysOfVacation(Person p)
    {
        if(p.getReservations()==null)
            return 0;
        int total = calcTotalDaysOfVacation(p);

        return total/p.getReservations().size();
    }

    private int calcAverageSpendingPerDay(Person p)
    {

        return calcTotalSpending(p)/calcTotalDaysOfVacation(p);
    }

}
