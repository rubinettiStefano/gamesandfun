package com.generation.gamesandfun.model.dtoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.gamesandfun.model.dto.document.DocumentDtoRpost;
import com.generation.gamesandfun.model.dto.document.DocumentDtoRput;
import com.generation.gamesandfun.model.dto.document.DocumentDtoWNoPerson;
import com.generation.gamesandfun.model.dto.document.DocumentDtoWPerson;
import com.generation.gamesandfun.model.entities.Document;
import com.generation.gamesandfun.model.entities.Person;
import com.generation.gamesandfun.model.repositories.PersonRepository;

@Service
public class DocumentConverter 
{
    @Autowired
    PersonRepository pRepo;

    public DocumentDtoWNoPerson documentToDtoWNoPerson(Document e)
    {
        return  DocumentDtoWNoPerson
                .builder()
                .id(e.getId())
                .number(e.getNumber())
                .type(e.getType())
                .expiring_date(e.getExpiring_date())
                .release_date(e.getRelease_date())
                .build();
    }

    public DocumentDtoWPerson documentToDtoWPerson(Document e)
    {
        return  DocumentDtoWPerson
                .builder()
                .id(e.getId())
                .number(e.getNumber())
                .type(e.getType())
                .expiring_date(e.getExpiring_date())
                .release_date(e.getRelease_date())
                .owner(e.getOwner())
                .build();
    }

    public Document dtoRpostToDocument(DocumentDtoRpost dto)
    {
        Person padre = pRepo.findById(dto.getPerson_id()).get();
        return  Document
                .builder()
                .number(dto.getNumber())
                .type(dto.getType())
                .expiring_date(dto.getExpiring_date())
                .release_date(dto.getRelease_date())
                .owner(padre)
                .build();
    }

    public Document dtoRputToDocument(DocumentDtoRput dto)
    {
        Person padre = null;

        Integer person_id = dto.getPerson_id();

        if(person_id!=null)
        {
            Optional<Person> op = pRepo.findById(person_id);

            if(op.isPresent())
                padre = op.get();
        }
        return  Document
                .builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .type(dto.getType())
                .expiring_date(dto.getExpiring_date())
                .release_date(dto.getRelease_date())
                .owner(padre)
                .build();
    }
}
