package com.mss.hms.services.impl;

import com.mss.hms.dto.TestDTO;
import com.mss.hms.entities.Test;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.TestRepository;
import com.mss.hms.services.TestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    private final ModelMapper modelMapper;

    @Override
    public TestDTO addTest(TestDTO testDTO) {
        return null;
    }

    @Override
    public List<TestDTO> getAllTests() {
        return null;
    }

    @Override
    public TestDTO getSingleTestById(Long testId) {
        return null;
    }

    @Override
    public TestDTO updateTest(TestDTO testDTO, Long testId) {
        return null;
    }

    @Override
    public boolean deleteTest(Long testId) {
        return false;
    }

    protected Test getTestById(Long TestId) {
        return this.testRepository.findById(TestId).orElseThrow(() ->
                new ResourceNotFoundException("Test", "Id", TestId)
        );
    }

    protected TestDTO TestToDTO(Test Test) {
        return this.modelMapper.map(Test, TestDTO.class);
    }

    protected Test dtoToTest(TestDTO TestDTO) {
        return this.modelMapper.map(TestDTO, Test.class);
    }

}
