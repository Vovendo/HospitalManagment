package ktelabs.edu.hospitalmanagement.repo;

import ktelabs.edu.hospitalmanagement.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
