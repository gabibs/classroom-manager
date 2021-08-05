package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.PersonalInformation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface PersonalInformationRepository extends CrudRepository<PersonalInformation, Integer> {
    PersonalInformation setTeacher(Integer id,
                                   String lastNames,
                                   String firstNames,
                                   String dni,
                                   String mainAddress,
                                   String phoneNbr,
                                   String email,
                                   LocalDate admissionDate,
                                   String professionalTitle,
                                   String professionalRegistration,
                                   LocalDate professionalTitleDate);

    PersonalInformation setStudent(Integer id,
                                   String lastNames,
                                   String firstNames,
                                   String dni,
                                   String mainAddress,
                                   String phoneNbr,
                                   String email,
                                   LocalDate admissionDate);

    PersonalInformation findByNameContains(String firstName);
    PersonalInformation findByLastNameContains(String lastName);
    PersonalInformation findByProfessionalTitle(String professionalTitle);
    PersonalInformation findByDni(String dni);

}
