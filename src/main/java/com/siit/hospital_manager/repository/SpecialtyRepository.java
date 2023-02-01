package com.siit.hospital_manager.repository;

import com.siit.hospital_manager.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
}
