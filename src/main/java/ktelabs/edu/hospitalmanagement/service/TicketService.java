package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {

    long save(Ticket ticket);

    Ticket findById(long id);

    List<Ticket> findAll();

    void deleteById(long id);

    List<Ticket> findFreeTicketsByDoctorIdAndDate(long doctorId, LocalDate date);

    List<Ticket> findOccupiedTicketsByPatientId(long patientId);

    List<Ticket> findOccupiedTicketsByPatientUuid(String patientUuid);

    void takeTicketByPatientId(long ticketId, long patientId);

    List<Ticket> addTickets(long doctorId, int numberOfAppointments, LocalDate date, int durationOfAppointments, int hourOfStart);
}
