package com.generation.gamesandfun.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesandfun.model.entities.Document;

public interface DocumentRepository extends JpaRepository<Document,Integer>
{
    List<Document> findByOwnerId(int ownerId);
}
