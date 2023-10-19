package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Direction;
import ktelabs.edu.hospitalmanagement.repo.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService{
    private final DirectionRepository directionRepository;

    @Override
    public List<Direction> findAll() {
        return (List<Direction>) directionRepository.findAll();
    }

    @Override
    public Direction findById(long id) {
        return directionRepository.findById(id).orElseThrow();
    }
}
