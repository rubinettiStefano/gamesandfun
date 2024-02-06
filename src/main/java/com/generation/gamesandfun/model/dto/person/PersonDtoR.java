package com.generation.gamesandfun.model.dto.person;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class PersonDtoR extends PersonDtoBase
{
    public PersonDtoR(){}
}
