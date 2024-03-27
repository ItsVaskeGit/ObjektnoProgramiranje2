package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllShips", query = "select s from Ship s")
})
public class Ship {
    
    public static final String GET_ALL_SHIPS = "getAllShips";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ship_seq")
    public Long id;

    private String name;
    private int capacity;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Set<Equipment> equipment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }
}
