package com.siit.hospital_manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "procedures")
@Data
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
