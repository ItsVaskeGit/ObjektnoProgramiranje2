package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Contract;
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
}
