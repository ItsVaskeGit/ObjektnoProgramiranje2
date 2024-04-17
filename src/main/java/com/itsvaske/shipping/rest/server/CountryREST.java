package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.model.Country;
import com.itsvaske.shipping.proxies.CountryProxy;
import com.itsvaske.shipping.services.CountryService;
import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Path("/api/country")
public class CountryREST {

    @RestClient
    private CountryProxy proxy;
    private List<Country> countries = new ArrayList<>();

    @Inject
    CountryService countryService;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountries() {
        countries = proxy.get();
        return Response.ok().entity(countries).build();
    }

    @Startup
    @Scheduled(cron = "0 9 1 1-12 * ?")
    @Transactional
    public void refreshCountriesDB() {
        countries = proxy.get();
        List<Country> existingOnes = countryService.getAllCountriesDB();
        for(Country c : existingOnes) {
            for(int i = 0; i < countries.size(); i++) {
                if(countries.get(i) == c) {
                    countries.remove(i);
                }
            }
        }
        for(Country c : countries) {
            countryService.addCountryDB(c);
        }
    }

    @GET
    @Path("/getAllCountries")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCountries() {
        List<Country> countries = countryService.getAllCountriesDB();

        return Response.ok().entity(countries).build();
    }

    @POST
    @Path("/addCountry")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCountry(Country c) {
        Country country = countryService.addCountryDB(c);

        return Response.ok().entity(country).build();
    }

    @GET
    @Path("/getCountryByCode")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCountryByCode(@QueryParam(value = "countryCode") String countryCode) {
        List<Country> countries = countryService.getCountryByCodeDB(countryCode);

        return Response.ok().entity(countries).build();
    }
}
