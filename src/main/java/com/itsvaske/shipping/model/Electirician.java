package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
public class Electirician {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Electritian_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private long JMBG;
    private int skillLevel;
    @ManyToOne
    private EmployeeRole employeeRole;

    @ManyToOne
    private Employee employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
