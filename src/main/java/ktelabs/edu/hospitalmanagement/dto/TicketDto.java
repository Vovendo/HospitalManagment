package ktelabs.edu.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private long id;
    private long patientId;
    private long doctorId;
    private LocalDateTime dateTime;
}
