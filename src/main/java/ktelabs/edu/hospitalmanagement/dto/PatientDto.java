package ktelabs.edu.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
}
