package com.generation.gamesandfun.model.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name,surname;
    private int age;

    @JsonIgnore
    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER)
    private List<Document> documents;

    @JsonIgnore
    @OneToMany(mappedBy = "guest",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Reservation> reservations;
}
