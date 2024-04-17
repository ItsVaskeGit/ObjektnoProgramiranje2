package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Contract;
import com.itsvaske.shipping.model.Ship;
import com.itsvaske.shipping.model.ShipCompany;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Dependent
public class ShipCompanyService {

    @Inject
    private EntityManager em;

    public List<ShipCompany> getAllShipCompaniesDB() {
        return em.createNamedQuery(ShipCompany.GET_ALL_SHIP_COMPANIES, ShipCompany.class).getResultList();
    }

    public List<Contract> getContractsByIdDB(int id) {
        return em.createNamedQuery(ShipCompany.GET_CONTRACTS_FOR_COMPANY, Contract.class).setParameter("id", id).getResultList();
    }

    public List<Ship> getShipsForCompanyDB(int id) {
        return em.createNamedQuery(ShipCompany.GET_SHIPS_FOR_COMPANY, Ship.class).setParameter("id", id).getResultList();
    }

    public ShipCompany addCompanyDB(ShipCompany sh) {
        return em.merge(sh);
    }
}
