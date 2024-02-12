package com.mss.hms.services.impl;

import com.mss.hms.dto.TestDTO;
import com.mss.hms.repository.TestRepository;
import com.mss.hms.services.TestService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

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
}
