package com.siit.hospital_manager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diagnoses")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


}
