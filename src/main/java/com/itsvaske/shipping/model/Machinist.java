package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Machinist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Machinist_seq")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "machinist_id")
    private Set<Repair> repairs;

    @ManyToOne
    private Employee employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
