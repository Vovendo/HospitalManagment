package ktelabs.edu.hospitalmanagement.mapper;

import ktelabs.edu.hospitalmanagement.dto.DoctorDto;
import ktelabs.edu.hospitalmanagement.model.Direction;
import ktelabs.edu.hospitalmanagement.model.Doctor;
import ktelabs.edu.hospitalmanagement.service.DirectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorMapper {
    private final DirectionService directionService;

    public Doctor doctorDtoToDoctor(DoctorDto doctorDto) {
        Direction direction = directionService.findById(doctorDto.getDirectionId());
        return new Doctor(doctorDto.getId(), doctorDto.getUuid(), doctorDto.getFirstName(), doctorDto.getLastName(), doctorDto.getPatronymic(), direction);
    }

    public DoctorDto doctorToDoctorDto(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getUuid(), doctor.getFirstName(), doctor.getLastName(), doctor.getPatronymic(), doctor.getDirection().getId());
    }
}
