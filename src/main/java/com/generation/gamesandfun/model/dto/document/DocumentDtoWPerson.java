package com.generation.gamesandfun.model.dto.document;

import com.generation.gamesandfun.model.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DocumentDtoWPerson extends DocumentDtoBase
{
    private Integer id;
    private Person owner;
}
