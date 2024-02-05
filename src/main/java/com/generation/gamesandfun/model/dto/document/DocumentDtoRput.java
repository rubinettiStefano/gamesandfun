package com.generation.gamesandfun.model.dto.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DocumentDtoRput extends DocumentDtoBase
{
    private Integer id;
    private Integer person_id;
}
