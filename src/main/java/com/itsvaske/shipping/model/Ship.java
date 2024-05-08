package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Ship.GET_ALL_SHIPS, query = "select s from Ship s"),
        @NamedQuery(name = Ship.GET_SHIP_BY_ID, query = "select s from Ship s where s.id = :id"),
        @NamedQuery(name = Ship.GET_ALL_SHIPS_BY_COUNTRY_OF_REGISTRATION, query = "select s from Ship s where s.countryOfRegistration.name = :name")
})
public class Ship {
    
    public static final String GET_ALL_SHIPS = "getAllShips";
    public static final String GET_SHIP_BY_ID = "getShipID";
    public static final String GET_ALL_SHIPS_BY_COUNTRY_OF_REGISTRATION = "getALlShipsByCountryOfRegistration";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ship_seq")
    private Long id;

    private String name;
    private int capacity;

    private String type;

    @OneToOne
    private Country countryOfRegistration;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "arrival_countries", joinColumns = {@JoinColumn(name = "ship_id")}, inverseJoinColumns = {@JoinColumn(name = "country_id")})
    private Set<Country> countryOfArrival = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Set<Equipment> equipment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Set<Employee> employees;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Set<Container> containers;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Set<Contract> contracts;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Country> getCountryOfArrival() {
        return countryOfArrival;
    }

    public void setCountryOfArrival(Set<Country> countryOfArrival) {
        this.countryOfArrival = countryOfArrival;
    }
}
