package com.siit.hospital_manager.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "procedures")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
