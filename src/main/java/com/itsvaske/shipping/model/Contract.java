package com.itsvaske.shipping.model;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = Contract.GET_ALL_CONTRACTS, query = "SELECT c FROM Contract c"),
        @NamedQuery(name = Contract.GET_CONTRACTS_BY_NUMBER, query = "Select c from Contract c where c.contractNumber = : number"),
        @NamedQuery(name = Contract.GET_CONTRACTED_SHIP, query = "select c.ship from Contract c where c.id = :id"),
        @NamedQuery(name = Contract.GET_ALL_CONTRACTS_BY_DEPARTURE_COUNTRY, query = "select c from Contract c where c.departureContry.name = :name"),
        @NamedQuery(name = Contract.GET_ALL_CONTRACTS_BY_ARRIVAL_COUNTRY, query = "select c from Contract c where c.arrivalCountry.name = :name")
})
public class Contract {

    public static final String GET_ALL_CONTRACTS = "getAllContracts";
    public static final String GET_CONTRACTS_BY_NUMBER = "getContractsByNumber";
    public static final String GET_CONTRACTED_SHIP = "getContractedShip";
    public static final String GET_ALL_CONTRACTS_BY_DEPARTURE_COUNTRY = "getAllContractsByDepartureCountry";
    public static final String GET_ALL_CONTRACTS_BY_ARRIVAL_COUNTRY = "getAllContractsByArrivalCountry";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Contract_seq")
    private Long id;

    @OneToOne
    private Country departureContry;

    @OneToOne
    private Country arrivalCountry;

    @ManyToOne(cascade = CascadeType.ALL)
    private CargoCompany cargoCompany;

    @ManyToOne(cascade = CascadeType.ALL)
    private ShipCompany shipCompany;

    @OneToOne(cascade = CascadeType.ALL)
    private Ship ship;

    private int contractNumber;
    private int price;
    private Date signDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
