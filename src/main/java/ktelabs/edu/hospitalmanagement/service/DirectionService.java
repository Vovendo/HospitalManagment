package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Direction;

import java.util.List;


public interface DirectionService {

    Direction findById(long id);

    List<Direction> findAll();
}
