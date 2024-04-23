package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Country;
import com.itsvaske.shipping.model.Ship;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Dependent
public class ShipService {

    @Inject
    EntityManager em;

    @Transactional
    public Ship addShipDB(Ship ship){
        return em.merge(ship);
    }

    public List<Ship> getAllShipsDB() {
        return em.createNamedQuery(Ship.GET_ALL_SHIPS, Ship.class).getResultList();
    }

    public List<Ship> getAllShipsByCountryOfRegistration(String country) {
        return em.createNamedQuery(Ship.GET_ALL_SHIPS_BY_COUNTRY_OF_REGISTRATION, Ship.class).setParameter("name", country).getResultList();
    }
}
