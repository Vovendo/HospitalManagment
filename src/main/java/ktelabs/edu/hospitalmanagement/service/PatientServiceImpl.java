package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Patient;
import ktelabs.edu.hospitalmanagement.repo.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public long save(Patient patient) {
        return patientRepository.save(patient).getId();
    }

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public Patient findById(long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(long id) {
        patientRepository.deleteById(id);
    }
}
