package com.generation.gamesandfun.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesandfun.model.entities.Document;

public interface DocumentRepository extends JpaRepository<Document,Integer>
{

}
