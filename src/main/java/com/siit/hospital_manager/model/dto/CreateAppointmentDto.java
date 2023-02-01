package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.Doctor;
import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.Specialty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CreateAppointmentDto {

    private LocalDateTime date;
    private Patient patient;
    private Doctor doctor;
    private Specialty specialty;
}
