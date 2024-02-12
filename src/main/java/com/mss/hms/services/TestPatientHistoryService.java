package com.mss.hms.services;

import com.mss.hms.dto.TestPatientHistoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestPatientHistoryService {

    TestPatientHistoryDTO addTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO);

    List<TestPatientHistoryDTO> getAllTestPatientHistories();

    TestPatientHistoryDTO getSingleTestPatientHistoryDTOById(Long testPatientHistoryId);

    TestPatientHistoryDTO updateTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO, Long testPatientHistoryId);

    boolean deleteTestPatientHistory(Long TestPatientHistoryId);

}
