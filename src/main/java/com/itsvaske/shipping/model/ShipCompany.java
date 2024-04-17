package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = ShipCompany.GET_ALL_SHIP_COMPANIES, query = "SELECT s FROM ShipCompany s"),
        @NamedQuery(name = ShipCompany.GET_SHIPS_FOR_COMPANY, query = "Select sh.ships from ShipCompany sh where sh.id = :id"),
        @NamedQuery(name = ShipCompany.GET_CONTRACTS_FOR_COMPANY, query = "Select sh.contracts from ShipCompany sh where sh.id = :id")

})
public class ShipCompany {

    public static final String GET_ALL_SHIP_COMPANIES = "getALlShipCompanies";
    public static final String GET_SHIPS_FOR_COMPANY = "getAllShipsForCompany";
    public static final String GET_CONTRACTS_FOR_COMPANY = "getContractsForCompany";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Machinist_seq")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "shipcompany_id")
    private Set<Ship> ships;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "shipcompany_id")
    private Set<Contract> contracts;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
