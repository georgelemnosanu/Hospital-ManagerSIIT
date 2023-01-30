package com.siit.hospital_manager.service;

import com.siit.hospital_manager.model.Doctor;
import com.siit.hospital_manager.model.dto.DoctorDto;
import com.siit.hospital_manager.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public List<DoctorDto> findAll(){
        return doctorRepository
                .findAll()
                .stream()
                .map(Doctor::toDto)
                .toList();
    }

}
