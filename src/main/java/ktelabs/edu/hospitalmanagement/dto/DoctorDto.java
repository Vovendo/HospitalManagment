package ktelabs.edu.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    private long directionId;
}
