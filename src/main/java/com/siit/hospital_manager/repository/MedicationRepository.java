package com.siit.hospital_manager.repository;

import com.siit.hospital_manager.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer> {
    Optional<Medication> findByName(String name);

    @Modifying
    @Query(value = "DELETE FROM medications where id = :id", nativeQuery = true)
    void deleteByIdNativeQuery(@Param("id") Integer id);

}
