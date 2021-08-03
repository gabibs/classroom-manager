package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

// @Data decorator auto-generates all getters and setters that do not exist with the name get/set<Attribute>
// @NoArgsConstructor decorator auto-generates a constructor with no arguments
@Data
@NoArgsConstructor
@Entity
public class Classroom {
    @Id
    private Integer id;
    private Integer capacity;

    /**
     * Creates a new classroom with a given capacity
     * @param capacity capacity of the new classroom
     */
    public Classroom(Integer capacity) {
        this.setCapacity(capacity);
    }
}
