package com.generation.gamesandfun.model.dto;

import java.util.List;

import com.generation.gamesandfun.model.entities.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDtoWFull 
{
    private Integer id;
    private String name,surname;
    private int age;

    private List<Document> documents;
}
