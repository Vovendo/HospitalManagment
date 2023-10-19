package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Doctor;
import ktelabs.edu.hospitalmanagement.repo.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository doctorRepository;

    @Override
    public long save(Doctor doctor) {
        return doctorRepository.save(doctor).getId();
    }

    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    public Doctor findById(long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(long id) {
        doctorRepository.deleteById(id);
    }
}
