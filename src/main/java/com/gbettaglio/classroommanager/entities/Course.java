package com.gbettaglio.classroommanager.entities;

import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.exceptions.UnexistingClassroom;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    private String yearOfEdition;
    private Double price = 0.00d;
    private String schedule;
    @OneToOne
    public Classroom classroom;
    @ManyToOne
    public Teacher teacher;
    @OneToMany
    public List<StudentCourse> studentsList = new ArrayList<StudentCourse>();

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
