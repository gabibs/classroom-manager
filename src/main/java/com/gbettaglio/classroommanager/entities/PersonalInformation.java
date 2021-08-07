package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class PersonalInformation {

    @Id
    private Integer id;
    private String lastName;
    private String firstName;
    private String dni;
    private String mainAddress;
    private String phoneNbr;
    private String email;
    private LocalDate admissionDate;
    private String professionalTitle;
    private String professionalRegistration;
    private LocalDate professionalTitleDate;
}
