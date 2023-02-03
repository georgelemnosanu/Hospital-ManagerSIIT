package com.siit.hospital_manager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="meds")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meds {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name="prescription_id")
    private Prescription prescription;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return  name;
    }
}
