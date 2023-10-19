package ktelabs.edu.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
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
    private String patronymic;
    @ManyToOne(fetch = FetchType.LAZY)
    private Direction direction;
    @OneToMany(mappedBy = "doctor")
    private List<Ticket> tickets;

    public Doctor(long id, String uuid, String firstName, String lastName, String patronymic, Direction direction) {
        this.id = id;
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.direction = direction;
    }
}
