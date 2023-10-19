package ktelabs.edu.hospitalmanagement.controller;

import jakarta.servlet.http.HttpServletResponse;
import ktelabs.edu.hospitalmanagement.dto.TicketDto;
import ktelabs.edu.hospitalmanagement.mapper.TicketMapper;
import ktelabs.edu.hospitalmanagement.model.Ticket;
import ktelabs.edu.hospitalmanagement.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping
    public TicketDto save(@RequestBody TicketDto ticketDto, HttpServletResponse response) {
        long id = ticketService.save(ticketMapper.ticketDtoToTicket(ticketDto));
        ticketDto.setId(id);
        response.setStatus(201);
        return ticketDto;
    }

    @GetMapping
    public List<TicketDto> findAll() {
        List<Ticket> ticketList = ticketService.findAll();
        return ticketList.stream().map(ticketMapper::ticketToTicketDto).toList();
    }

    @GetMapping("/{ticketId}")
    public TicketDto findById(@PathVariable long ticketId) {
        return ticketMapper.ticketToTicketDto(ticketService.findById(ticketId));
    }

    @DeleteMapping("/{ticketId}")
    public void deleteById(@PathVariable long ticketId, HttpServletResponse response) {
        ticketService.deleteById(ticketId);
        response.setStatus(204);
    }

    @GetMapping("/patient")
    public List<TicketDto> findOccupiedTicketsByPatientUuid(@RequestParam String patientUuid) {
        List<Ticket> ticketList = ticketService.findOccupiedTicketsByPatientUuid(patientUuid);
        return ticketList.stream().map(ticketMapper::ticketToTicketDto).toList();
    }
}
