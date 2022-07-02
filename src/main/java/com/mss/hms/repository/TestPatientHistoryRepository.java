package com.mss.hms.repository;

import com.mss.hms.entities.TestPatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPatientHistoryRepository extends JpaRepository<TestPatientHistory, Long> {
}
