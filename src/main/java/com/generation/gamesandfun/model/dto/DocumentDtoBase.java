package com.generation.gamesandfun.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DocumentDtoBase
{
    private LocalDate release_date,expiring_date;
    private String type,number;
}
