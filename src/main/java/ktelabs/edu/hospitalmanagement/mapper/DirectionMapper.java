package ktelabs.edu.hospitalmanagement.mapper;

import ktelabs.edu.hospitalmanagement.dto.DirectionDto;
import ktelabs.edu.hospitalmanagement.model.Direction;

public class DirectionMapper {

    public Direction directionDtoToDirection(DirectionDto directionDto) {
        return new Direction(directionDto.getId(), directionDto.getName());
    }

    public DirectionDto directionToDirectionDto(Direction direction) {
        return new DirectionDto(direction.getId(), direction.getName());
    }
}
