package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Doctor;

import java.util.List;

public interface DoctorService {

    long save(Doctor doctor);

    List<Doctor> findAll();

    Doctor findById(long id);

    void deleteById(long id);
}
