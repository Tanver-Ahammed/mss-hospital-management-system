package com.mss.hms.services;

import com.mss.hms.dto.VisitedDayDTO;
import com.mss.hms.entities.VisitedDay;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.VisitedDayRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitedDayService {

    private VisitedDayRepository visitedDayRepository;

    private ModelMapper modelMapper;

    public List<VisitedDayDTO> getAllVisitedDays() {
        return this.visitedDayRepository
                .findAll()
                .stream()
                .map(VisitedDay -> modelMapper.map(VisitedDay, VisitedDayDTO.class))
                .toList();
    }

    public VisitedDayDTO getSingleVisitedDayById(Long VisitedDayId) {
        return this.modelMapper.map(this.getVisitedDayById(VisitedDayId), VisitedDayDTO.class);
    }

    public VisitedDay getVisitedDayById(Long VisitedDayId) {
        return this.visitedDayRepository.findById(VisitedDayId).orElseThrow(() ->
                new ResourceNotFoundException("VisitedDay", "Id", VisitedDayId));
    }

}
