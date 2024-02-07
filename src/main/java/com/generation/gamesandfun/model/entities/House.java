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
public class House 
{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city,address; 

     @JsonIgnore
    @OneToMany(mappedBy = "house",fetch = FetchType.EAGER)
    private List<Reservation> reservations;
}
