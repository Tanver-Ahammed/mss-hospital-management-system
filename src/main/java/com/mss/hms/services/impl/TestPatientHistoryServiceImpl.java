package com.mss.hms.services.impl;

import com.mss.hms.dto.TestPatientHistoryDTO;
import com.mss.hms.repository.TestPatientHistoryRepository;
import com.mss.hms.services.TestPatientHistoryService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TestPatientHistoryServiceImpl implements TestPatientHistoryService {

    private TestPatientHistoryRepository testPatientHistoryRepository;

    @Override
    public TestPatientHistoryDTO addTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO) {
        return null;
    }

    @Override
    public List<TestPatientHistoryDTO> getAllTestPatientHistories() {
        return null;
    }

    @Override
    public TestPatientHistoryDTO getSingleTestPatientHistoryDTOById(Long testPatientHistoryId) {
        return null;
    }

    @Override
    public TestPatientHistoryDTO updateTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO, Long testPatientHistoryId) {
        return null;
    }

    @Override
    public boolean deleteTestPatientHistory(Long TestPatientHistoryId) {
        return false;
    }
}
