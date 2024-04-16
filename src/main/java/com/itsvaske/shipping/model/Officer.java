package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Officer_seq")
    private Long id;

    @ManyToOne
    private Employee employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
