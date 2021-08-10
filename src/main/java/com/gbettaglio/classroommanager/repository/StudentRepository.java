package com.gbettaglio.classroommanager.repository;

import java.util.List;

import com.gbettaglio.classroommanager.entities.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByPersonalInformationLastNameContainsAndPersonalInformationDniContains(String lastName,
            String dni);

    List<Student> findAllByPersonalInformationLastNameContainsAndPersonalInformationDniContains(String lastName,
            String dni);

}
