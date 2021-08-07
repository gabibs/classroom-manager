package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByPersonalInformationLastNameContainsAndDniContains(String lastName, String dni);
    Student findByStudentCourseContainsStudentAndIdContains(String student, Integer id); 
    //TODO: verify last method



}
