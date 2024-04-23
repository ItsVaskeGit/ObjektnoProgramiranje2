package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Contract;
import com.itsvaske.shipping.model.Ship;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Dependent
public class ContractService {

    @Inject
    private EntityManager em;

    public List<Contract> getAllContractsDB() {
        return em.createNamedQuery(Contract.GET_ALL_CONTRACTS, Contract.class).getResultList();
    }

    public List<Contract> getContractsByNumberDB(int number) {
        return em.createNamedQuery(Contract.GET_CONTRACTS_BY_NUMBER, Contract.class).setParameter("number", number).getResultList();
    }

    public Ship getContractedShip(int id) {
        return em.createNamedQuery(Contract.GET_CONTRACTED_SHIP, Ship.class).setParameter("id", id).getSingleResult();
    }

    public List<Contract> getContractsByDepartureCountry(String name) {
        return em.createNamedQuery(Contract.GET_ALL_CONTRACTS_BY_DEPARTURE_COUNTRY, Contract.class).setParameter("name", name).getResultList();
    }

    public List<Contract> getContractsByArrivalCountry(String name) {
        return em.createNamedQuery(Contract.GET_ALL_CONTRACTS_BY_ARRIVAL_COUNTRY, Contract.class).setParameter("name", name).getResultList();
    }
}
