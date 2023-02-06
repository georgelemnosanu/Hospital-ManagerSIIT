package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Medication;
import com.siit.hospital_manager.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;


    public void createMedication(String name){
        medicationRepository.findByName(name).ifPresent(medication -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Medication Already Exists");
        });
        Medication medication = new Medication();
        medication.setName(name);
        medicationRepository.save(medication);
    }

    @Transactional
    public void deleteMedication(Integer id){
        Medication medication = medicationRepository.findById(id).orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"Medication not found"));
        medicationRepository.deleteByIdNativeQuery(medication.getId());
    }


}
