package ktelabs.edu.hospitalmanagement.mapper;

import ktelabs.edu.hospitalmanagement.dto.PatientDto;
import ktelabs.edu.hospitalmanagement.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient patientDtoToPatient(PatientDto patientDto) {
        return new Patient(patientDto.getId(), patientDto.getUuid(), patientDto.getFirstName(), patientDto.getLastName(), patientDto.getPatronymic(), patientDto.getDateOfBirth());
    }

    public PatientDto patientToPatientDto(Patient patient) {
        return new PatientDto(patient.getId(), patient.getUuid(), patient.getFirstName(), patient.getLastName(), patient.getPatronymic(), patient.getDateOfBirth());
    }
}
