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

    private Country arrivalCountry;
    private Country departureCountry;
    private Country registrationCountry;
    private String type;

    @Transactional
    public Ship addShipDB(Ship ship){
        return em.merge(ship);
    }

    public List<Ship> getAllShipsDB() {
        return em.createNamedQuery(Ship.GET_ALL_SHIPS, Ship.class).getResultList();
    }

    public Country getArrivalCountry() {
        return arrivalCountry;
    }

    public void setArrivalCountry(Country arrivalCountry) {
        this.arrivalCountry = arrivalCountry;
    }

    public Country getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(Country departureCountry) {
        this.departureCountry = departureCountry;
    }

    public Country getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(Country registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
