package com.siit.hospital_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedsRepository extends JpaRepository<Meds, Integer> {

}
