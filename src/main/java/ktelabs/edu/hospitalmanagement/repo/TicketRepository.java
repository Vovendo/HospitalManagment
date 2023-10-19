package ktelabs.edu.hospitalmanagement.repo;

import ktelabs.edu.hospitalmanagement.model.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findByPatient_IdIsNullAndDoctor_IdAndDateTimeBetween(long doctorId, LocalDateTime to, LocalDateTime from);

    List<Ticket> findByPatient_Id(long patientId);

    List<Ticket> findByPatient_Uuid(String patientUuid);
}
