package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@ToString
@Data
@NoArgsConstructor
@Entity
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastName;
    private String firstName;
    private String dni;
    private String mainAddress;
    private String phoneNbr;
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate admissionDate;

    private String professionalTitle;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String professionalRegistration;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate professionalTitleDate;
}
