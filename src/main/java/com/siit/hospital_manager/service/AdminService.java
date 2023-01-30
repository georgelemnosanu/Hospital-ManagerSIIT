package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Doctor;
import com.siit.hospital_manager.model.dto.CreateDoctorDto;
import com.siit.hospital_manager.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final DoctorRepository doctorRepository;
    public void createDoctor(CreateDoctorDto createDoctorDto) {
        Doctor doctor = Doctor.fromDto(createDoctorDto);

        doctorRepository.findByName(createDoctorDto.getName()).ifPresent(doctorInDb -> {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Doctor already exists!");
        });
        doctorRepository.save(doctor);
    }
}
