package com.siit.hospital_manager.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medications")
@Data
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}