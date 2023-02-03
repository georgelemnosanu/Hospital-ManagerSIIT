package com.siit.hospital_manager.service;

import com.siit.hospital_manager.repository.MedsRepository;
import com.siit.hospital_manager.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedsRepository medsRepository;


}




