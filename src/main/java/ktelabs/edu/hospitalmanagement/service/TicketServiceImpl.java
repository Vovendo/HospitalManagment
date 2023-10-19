package ktelabs.edu.hospitalmanagement.service;

import ktelabs.edu.hospitalmanagement.model.Doctor;
import ktelabs.edu.hospitalmanagement.model.Patient;
import ktelabs.edu.hospitalmanagement.model.Ticket;
import ktelabs.edu.hospitalmanagement.repo.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @Override
    public long save(Ticket ticket) {
        return ticketRepository.save(ticket).getId();
    }

    @Override
    public Ticket findById(long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findFreeTicketsByDoctorIdAndDate(long doctorId, LocalDate date) {
        LocalDateTime to = LocalDateTime.of(date, LocalTime.of(0, 0, 0));
        LocalDateTime from = LocalDateTime.of(date, LocalTime.of(23, 59, 0));
        return ticketRepository.findByPatient_IdIsNullAndDoctor_IdAndDateTimeBetween( doctorId, to, from);
    }

    @Override
    public List<Ticket> findOccupiedTicketsByPatientId(long patientId) {
        return ticketRepository.findByPatient_Id(patientId);
    }

    @Override
    public List<Ticket> findOccupiedTicketsByPatientUuid(String patientUuid) {
        return ticketRepository.findByPatient_Uuid(patientUuid);
    }

    @Override
    @Transactional
    public void takeTicketByPatientId(long ticketId, long patientId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        Patient patient = patientService.findById(patientId);
        ticket.setPatient(patient);
        ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public List<Ticket> addTickets(long doctorId, int numberOfAppointments, LocalDate date, int durationOfAppointments, int hourOfStart) {
        List<Ticket> ticketList = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(hourOfStart, 0, 0));
        Doctor doctor = doctorService.findById(doctorId);
        for(int i = 0; i < numberOfAppointments; i++) {
            Ticket ticket = new Ticket(null, doctor, dateTime);
            dateTime = dateTime.plusMinutes(durationOfAppointments);
            ticketList.add(ticket);
        }
        ticketRepository.saveAll(ticketList);
        return ticketList;
    }
}
