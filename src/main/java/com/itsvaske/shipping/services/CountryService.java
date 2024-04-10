package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Country;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/countries")
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

    @GET
    @Path("/getAllCountries")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCountries() {
        List<Country> countries = getAllCountriesDB();

        return Response.ok().entity(countries).build();
    }

    @POST
    @Path("/addCountry")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCountry(Country c) {
        Country country = addCountryDB(c);

        return Response.ok().entity(country).build();
    }

    @GET
    @Path("/getCountryByCode")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCountryByCode(@QueryParam(value = "countryCode") String countryCode) {
        List<Country> countries = getCountryByCodeDB(countryCode);

        return Response.ok().entity(countries).build();
    }
}
