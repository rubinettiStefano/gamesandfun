package com.generation.gamesandfun.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesandfun.model.dto.document.DocumentDtoRpost;
import com.generation.gamesandfun.model.dto.document.DocumentDtoRput;
import com.generation.gamesandfun.model.dto.document.DocumentDtoWNoPerson;
import com.generation.gamesandfun.model.dto.document.DocumentDtoWPerson;
import com.generation.gamesandfun.model.dtoservices.DocumentConverter;
import com.generation.gamesandfun.model.entities.Document;
import com.generation.gamesandfun.model.repositories.DocumentRepository;



@RestController
public class DocumentController 
{

    @Autowired
    DocumentRepository repo;
    @Autowired
    DocumentConverter conv;

    @GetMapping("/documents")
    public List<DocumentDtoWNoPerson> getAll() 
    {
        return repo.findAll().stream().map(d -> conv.documentToDtoWNoPerson(d)).toList();
    }
    
    @PostMapping("/documents")
    public DocumentDtoWPerson insert(@RequestBody DocumentDtoRpost dto) 
    {
        Document d = conv.dtoRpostToDocument(dto);
        return conv.documentToDtoWPerson(repo.save(d));
    }
    
    @GetMapping("/documents/{id}")
    public DocumentDtoWNoPerson getOne(@PathVariable Integer id) 
    {
       Optional<Document> op = repo.findById(id);

       if(op.isEmpty())
        return null;

        return conv.documentToDtoWNoPerson(op.get());
    }

    @GetMapping("/documents/{id}/per")
    public DocumentDtoWPerson getOneWithPers(@PathVariable Integer id) 
    {
       Optional<Document> op = repo.findById(id);

       if(op.isEmpty())
        return null;

        return conv.documentToDtoWPerson(op.get());
    }

    @PutMapping("/documents")
    public DocumentDtoWPerson update(@RequestBody DocumentDtoRput dto) 
    {
        Document d = conv.dtoRputToDocument(dto);
        return conv.documentToDtoWPerson(repo.save(d));
    }

    @PutMapping("/documents/{id}")
    public DocumentDtoWPerson updateWithId(@RequestBody DocumentDtoRput dto,@PathVariable Integer id) 
    {
        dto.setId(id);
        Document d = conv.dtoRputToDocument(dto);
        return conv.documentToDtoWPerson(repo.save(d));
    }

    @DeleteMapping("/documents/{id}")
    public void  deleteDocument(@PathVariable Integer id) 
    {
        repo.deleteById(id);
    }
}
