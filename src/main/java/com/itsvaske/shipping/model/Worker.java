package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Worker_seq")
    private Long id;

    private int workTime;
    @ManyToOne
    private Employee employee;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
