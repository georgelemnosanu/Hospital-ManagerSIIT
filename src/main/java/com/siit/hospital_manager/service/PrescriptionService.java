package com.siit.hospital_manager.service;

import com.siit.hospital_manager.model.Meds;
import com.siit.hospital_manager.model.Prescription;
import com.siit.hospital_manager.repository.MedsRepository;
import com.siit.hospital_manager.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedsRepository medsRepository;


}




