package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Patient;

import java.util.List;

public interface PatientService {

    long save(Patient patient);

    List<Patient> findAll();

    Patient findById(long id);

    void deleteById(long id);
}
