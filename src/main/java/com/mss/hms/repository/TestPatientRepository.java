package com.mss.hms.repository;

import com.mss.hms.entities.TestPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPatientRepository extends JpaRepository<TestPatient, Long> {
}
