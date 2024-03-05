package com.mss.hms.services;

import com.mss.hms.dto.TestPatientHistoryDTO;
import com.mss.hms.entities.TestPatientHistory;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.TestPatientHistoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class TestPatientHistoryService {

    private final TestPatientHistoryRepository testPatientHistoryRepository;

    private final ModelMapper modelMapper;

    public TestPatientHistoryDTO addTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO) {
        return null;
    }

    public List<TestPatientHistoryDTO> getAllTestPatientHistories() {
        return null;
    }

    public TestPatientHistoryDTO getSingleTestPatientHistoryDTOById(Long testPatientHistoryId) {
        return null;
    }

    public TestPatientHistoryDTO updateTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO, Long testPatientHistoryId) {
        return null;
    }

    public boolean deleteTestPatientHistory(Long TestPatientHistoryId) {
        return false;
    }

    protected TestPatientHistory getTestPatientHistoryById(Long testPatientHistoryId) {
        return this.testPatientHistoryRepository.findById(testPatientHistoryId).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", testPatientHistoryId)
        );
    }

    protected TestPatientHistoryDTO testPatientHistoryToDTO(TestPatientHistory testPatientHistory) {
        return this.modelMapper.map(testPatientHistory, TestPatientHistoryDTO.class);
    }

    protected TestPatientHistory dtoToTestPatientHistory(TestPatientHistoryDTO testPatientHistoryDTO) {
        return this.modelMapper.map(testPatientHistoryDTO, TestPatientHistory.class);
    }

}
