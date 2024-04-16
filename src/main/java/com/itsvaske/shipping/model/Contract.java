package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = Contract.GET_ALL_CONTRACTS, query = "SELECT c FROM Contract c"),
        @NamedQuery(name = Contract.GET_CONTRACTS_BY_NUMBER, query = "Select c from Contract c where c.contractNumber = : number")
})
public class Contract {

    public static final String GET_ALL_CONTRACTS = "getAllContracts";
    public static final String GET_CONTRACTS_BY_NUMBER = "getContractsByNumber";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Contract_seq")
    private Long id;

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
