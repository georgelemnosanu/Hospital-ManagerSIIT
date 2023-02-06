package com.siit.hospital_manager.repository;

import com.siit.hospital_manager.model.Appointment;
import com.siit.hospital_manager.model.Diagnosis;
import com.siit.hospital_manager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

    Optional<Diagnosis> findByName(String name);

    @Modifying
    @Query(value = "DELETE FROM diagnoses where id = :id", nativeQuery = true)
    void deleteByIdNativeQuery(@Param("id") Integer id);


}
