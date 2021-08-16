package com.gbettaglio.classroommanager.repository;

import java.util.List;

import com.gbettaglio.classroommanager.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    Teacher findByPersonalInformationLastNameContainsAndPersonalInformationDniContains(String lastName, String dni);

    List<Teacher> findAllByPersonalInformationLastNameContainsAndPersonalInformationDniContains(String lastName,
            String dni);

}
