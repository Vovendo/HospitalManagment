package ktelabs.edu.hospitalmanagement.controller;


import ktelabs.edu.hospitalmanagement.dto.PatientDto;
import ktelabs.edu.hospitalmanagement.dto.TicketDto;
import ktelabs.edu.hospitalmanagement.mapper.PatientMapper;
import ktelabs.edu.hospitalmanagement.mapper.TicketMapper;
import ktelabs.edu.hospitalmanagement.model.Patient;
import ktelabs.edu.hospitalmanagement.model.Ticket;
import ktelabs.edu.hospitalmanagement.service.PatientService;
import ktelabs.edu.hospitalmanagement.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final PatientMapper patientMapper;
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping
    public PatientDto save(@RequestBody PatientDto patientDto, HttpServletResponse response) {
        patientDto.setUuid(UUID.nameUUIDFromBytes((patientDto.getFirstName() + patientDto.getLastName() + LocalDateTime.now()).getBytes()).toString());
        long id = patientService.save(patientMapper.patientDtoToPatient(patientDto));
        patientDto.setId(id);
        response.setStatus(201);
        return patientDto;
    }

    @PutMapping
    public PatientDto update(@RequestBody PatientDto patientDto) {
        patientService.save(patientMapper.patientDtoToPatient(patientDto));
        return patientDto;
    }

    @GetMapping
    public List<PatientDto> findAll() {
        List<Patient> patientList = patientService.findAll();
        return patientList.stream().map(patientMapper::patientToPatientDto).toList();
    }

    @GetMapping("/{patientId}")
    public PatientDto findById(@PathVariable long patientId) {
        return patientMapper.patientToPatientDto(patientService.findById(patientId));
    }

    @DeleteMapping("/{patientId}")
    public void deleteById(@PathVariable long patientId, HttpServletResponse response) {
        patientService.deleteById(patientId);
        response.setStatus(204);
    }

    @PutMapping("/{patientId}/ticket/{ticketId}")
    public void takeTicket(@PathVariable long patientId,@PathVariable long ticketId) {
        ticketService.takeTicketByPatientId(ticketId, patientId);
    }

    @GetMapping("/{patientId}/ticket")
    public List<TicketDto> findOccupiedTickets(@PathVariable long patientId) {
        List<Ticket> ticketList = ticketService.findOccupiedTicketsByPatientId(patientId);
        return ticketList.stream().map(ticketMapper::ticketToTicketDto).toList();
    }

    @GetMapping("/ticket")
    public List<TicketDto> findOccupiedTicketsByUuid(@RequestParam String uuid) {
        List<Ticket> ticketList = ticketService.findOccupiedTicketsByPatientUuid(uuid);
        return ticketList.stream().map(ticketMapper::ticketToTicketDto).toList();
    }
}
