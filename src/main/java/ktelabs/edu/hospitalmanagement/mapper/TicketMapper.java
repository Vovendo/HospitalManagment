package ktelabs.edu.hospitalmanagement.mapper;

import ktelabs.edu.hospitalmanagement.dto.TicketDto;
import ktelabs.edu.hospitalmanagement.model.Doctor;
import ktelabs.edu.hospitalmanagement.model.Patient;
import ktelabs.edu.hospitalmanagement.model.Ticket;
import ktelabs.edu.hospitalmanagement.service.DoctorService;
import ktelabs.edu.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TicketMapper {
    private final PatientService patientService;
    private final DoctorService doctorService;

    @Transactional
    public Ticket ticketDtoToTicket(TicketDto ticketDto) {
        Patient patient = patientService.findById(ticketDto.getPatientId());
        Doctor doctor = doctorService.findById(ticketDto.getDoctorId());
        return new Ticket(ticketDto.getId(), patient, doctor, ticketDto.getDateTime());
    }

    public TicketDto ticketToTicketDto(Ticket ticket) {
        if(ticket.getPatient() == null) {
            return new TicketDto(ticket.getId(), 0, ticket.getDoctor().getId(), ticket.getDateTime());
        }
        return new TicketDto(ticket.getId(), ticket.getPatient().getId(), ticket.getDoctor().getId(), ticket.getDateTime());
    }
}
