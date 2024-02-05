package com.generation.gamesandfun.model.dtoservices;


import org.springframework.stereotype.Service;

import com.generation.gamesandfun.model.dto.person.PersonDtoR;
import com.generation.gamesandfun.model.dto.person.PersonDtoWFull;
import com.generation.gamesandfun.model.dto.person.PersonDtoWNoDocuments;
import com.generation.gamesandfun.model.entities.Person;

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
}
