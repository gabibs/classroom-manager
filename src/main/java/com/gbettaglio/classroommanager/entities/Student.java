package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@ToString
@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    public PersonalInformation personalInformation;
    public Boolean approved;
    @OneToMany
    public List<StudentCourse> courses;

}
