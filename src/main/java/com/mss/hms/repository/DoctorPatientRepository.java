package com.mss.hms.repository;

import com.mss.hms.entities.DoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Long> {
}
