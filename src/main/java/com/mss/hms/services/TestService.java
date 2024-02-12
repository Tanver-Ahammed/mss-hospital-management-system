package com.mss.hms.services;

import com.mss.hms.dto.TestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

    TestDTO addTest(TestDTO testDTO);

    List<TestDTO> getAllTests();

    TestDTO getSingleTestById(Long testId);

    TestDTO updateTest(TestDTO testDTO, Long testId);

    boolean deleteTest(Long testId);
    
}
