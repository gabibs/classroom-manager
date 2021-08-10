package com.gbettaglio.classroommanager.entities;

import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.exceptions.UnexistingClassroom;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {

    @Id
    private Integer id;
    private String name;
    private LocalDate startDate;
    private String yearOfEdition;
    private Double price = 0.00d;
    private String schedule;
    @OneToOne
    private Classroom classroom;
    @ManyToOne
    private Teacher teachers;
    @OneToMany
    private List<StudentCourse> studentsList = new ArrayList<StudentCourse>();

    public LocalDate getEndDate() {
        return startDate.plusMonths(6);
    }

    public void saveStudent(Student student) throws FullClassException, UnexistingClassroom {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(student);

        if (classroom == null) {
            throw new UnexistingClassroom();
        }

        if (this.studentsList.size() == classroom.getCapacity()) {
            throw new FullClassException();
        } else {
            this.studentsList.add(studentCourse);
        }
    }
}
