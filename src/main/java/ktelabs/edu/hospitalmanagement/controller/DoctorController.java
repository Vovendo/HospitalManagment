package ktelabs.edu.hospitalmanagement.controller;


import ktelabs.edu.hospitalmanagement.dto.DoctorDto;
import ktelabs.edu.hospitalmanagement.dto.TicketDto;
import ktelabs.edu.hospitalmanagement.mapper.DoctorMapper;
import ktelabs.edu.hospitalmanagement.mapper.TicketMapper;
import ktelabs.edu.hospitalmanagement.model.Doctor;
import ktelabs.edu.hospitalmanagement.model.Ticket;
import ktelabs.edu.hospitalmanagement.service.DoctorService;
import ktelabs.edu.hospitalmanagement.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping
    public DoctorDto save(@RequestBody DoctorDto doctorDto, HttpServletResponse response) {
        doctorDto.setUuid(UUID.nameUUIDFromBytes((doctorDto.getFirstName() + doctorDto.getLastName() + LocalDateTime.now()).getBytes()).toString());
        long id = doctorService.save(doctorMapper.doctorDtoToDoctor(doctorDto));
        doctorDto.setId(id);
        response.setStatus(201);
        return doctorDto;
    }

    @PutMapping
    public DoctorDto update(@RequestBody DoctorDto doctorDto) {
        doctorService.save(doctorMapper.doctorDtoToDoctor(doctorDto));
        return doctorDto;
    }

    @GetMapping
    public List<DoctorDto> findAll() {
        List<Doctor> doctorList = doctorService.findAll();
        return doctorList.stream().map(doctorMapper::doctorToDoctorDto).toList();
    }

    @GetMapping("/{doctorId}")
    public DoctorDto findById(@PathVariable long doctorId) {
        return doctorMapper.doctorToDoctorDto(doctorService.findById(doctorId));
    }

    @DeleteMapping("/{doctorId}")
    public void deleteById(@PathVariable long doctorId, HttpServletResponse response) {
        doctorService.deleteById(doctorId);
        response.setStatus(204);
    }

    @GetMapping("/{doctorId}/ticket")
    public List<TicketDto> findFreeTicketsByDate(@PathVariable long doctorId, @RequestParam int day, int month, int year) {
        List<Ticket> ticketList = ticketService.findFreeTicketsByDoctorIdAndDate(doctorId, LocalDate.of(year, month, day));
        return ticketList.stream().map(ticketMapper::ticketToTicketDto).toList();
    }
}
