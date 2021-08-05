package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private Integer id;
    @OneToOne
    private PersonalInformation personalInformation;
    private Boolean approved;
    private Float score;
    @OneToMany
    private List<StudentCourse> courses;

    public Object getCurrent() {
        return null;
    }

}
