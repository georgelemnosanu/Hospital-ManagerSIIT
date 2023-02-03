package com.siit.hospital_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.model.dto.Procedure;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JsonIgnore
    private Specialty specialty;

    @OneToMany
    private List<Diagnosis> diagnoses;

    @OneToMany
    private List<Procedure> procedures;

    @OneToMany
    private List<Medication> medications;

    private String summary;



    public AppointmentDto toDto(){

        return AppointmentDto
                .builder()
                .id(id)
                .date(date)
                .patient(patient)
                .doctor(doctor)
                .build();
    }
}
