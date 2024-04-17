package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Country;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Dependent
public class CountryService {

    @Inject
    EntityManager em;

    public List<Country> getAllCountriesDB() {
        return em.createNamedQuery(Country.GET_ALL_COUNTRIES, Country.class).getResultList();
    }

    public Country addCountryDB(Country c) {
        return em.merge(c);
    }

    public List<Country> getCountryByCodeDB(String countryCode) {
        return em.createNamedQuery(Country.GET_COUNTRY_BY_CODE, Country.class).setParameter("countryCode", countryCode).getResultList();
    }
}
