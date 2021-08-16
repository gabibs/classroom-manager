package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// @Data decorator auto-generates all getters and setters that do not exist with the name get/set<Attribute>
// @NoArgsConstructor decorator auto-generates a constructor with no arguments
@ToString
@NoArgsConstructor
@Entity
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer capacity;

}
