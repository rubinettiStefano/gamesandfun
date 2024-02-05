package com.generation.gamesandfun.model.dto.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DocumentDtoRpost extends DocumentDtoBase
{
    private Integer person_id;
}
