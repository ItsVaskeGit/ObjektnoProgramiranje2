package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
public class Electirician {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Electritian_seq")
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
