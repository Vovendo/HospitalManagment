package ktelabs.edu.hospitalmanagement.repo;

import ktelabs.edu.hospitalmanagement.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
