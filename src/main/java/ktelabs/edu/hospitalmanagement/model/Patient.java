package ktelabs.edu.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String uuid;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String patronymic;
    @OneToMany(mappedBy = "patient")
    private List<Ticket> tickets;

    public Patient(long id, String uuid, String firstName, String lastName, String patronymic, LocalDate dateOfBirth) {
        this.id = id;
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }
}
