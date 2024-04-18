package com.itsvaske.shipping.services;

import com.itsvaske.shipping.interfaces.LogMechanism;
import com.itsvaske.shipping.model.CargoCompany;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Path;

import java.util.List;

@Dependent
public class CargoCompanyService {

    @Inject
    private EntityManager em;

    public List<CargoCompany> getAllCargoCompaniesDB() {
        return em.createNamedQuery(CargoCompany.GET_ALL_CARGO_COMPANIES, CargoCompany.class).getResultList();
    }

    public List<CargoCompany> getContractsByNumberDB(int id) {
        return em.createNamedQuery(CargoCompany.GET_CARGO_COMPANY_CONTRACTS, CargoCompany.class).setParameter("id", id).getResultList();
    }

    public CargoCompany addCompanyDB(CargoCompany cargoCompany) {
        return em.merge(cargoCompany);
    }
}
