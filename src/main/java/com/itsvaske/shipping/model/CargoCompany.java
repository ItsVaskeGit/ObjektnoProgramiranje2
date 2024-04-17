package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = CargoCompany.GET_ALL_CARGO_COMPANIES, query = "SELECT c FROM CargoCompany c"),
        @NamedQuery(name = CargoCompany.GET_CARGO_COMPANY_CONTRACTS, query = "Select c.contracts from CargoCompany c where c.id = :id")
})
public class CargoCompany {

    public static final String GET_ALL_CARGO_COMPANIES = "getAllCargoCompanies";
    public static final String GET_CARGO_COMPANY_CONTRACTS = "getCargoCompanyContracts";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Machinist_seq")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id")
    private Set<Contract> contracts;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
