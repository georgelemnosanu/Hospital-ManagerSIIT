package com.siit.hospital_manager.repository;

import com.siit.hospital_manager.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
}
