package com.siit.hospital_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siit.hospital_manager.model.dto.CreateDoctorDto;
import com.siit.hospital_manager.model.dto.DoctorDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name="doctors")
@Data
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@SuperBuilder
@NoArgsConstructor

public class Doctor extends User{

    private String name;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments;

    @ManyToOne
    private Specialty specialty;

    public DoctorDto toDto() {
        return DoctorDto
                .builder()
                .name(name)
                .id(getId())
                .specialty(specialty)
                .build();
    }

    public static Doctor fromDto(CreateDoctorDto createDoctorDto){
        return Doctor
                .builder()
                .userName(createDoctorDto.getUserName())
                .name(createDoctorDto.getName())
                .specialty(createDoctorDto.getSpecialty())
                .password(createDoctorDto.getPassword())
                .isActive(true)
                .roles("ROLE_DOCTOR")
                .build();
    }

    @Override
    public String toString(){
        return specialty.getName();
    }
}
