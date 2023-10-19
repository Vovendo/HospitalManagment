package ktelabs.edu.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;
    @Column
    private LocalDateTime dateTime;

    public Ticket(Patient patient, Doctor doctor, LocalDateTime dateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }
}
