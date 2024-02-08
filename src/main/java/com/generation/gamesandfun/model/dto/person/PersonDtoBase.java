package com.generation.gamesandfun.model.dto.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class PersonDtoBase 
{
    private String name,surname;
    private int age;

    // {
    //     "name":"Stefano",
    //     "surname":"Rubinetti",
    //     "age":28
    // }
}
