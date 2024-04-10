package com.itsvaske.shipping.proxies;

import com.itsvaske.shipping.model.Country;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/countryProxy")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://date.nager.at/api/v3/AvailableCountries")
public interface CountryProxy {

    @GET
    @Path("/allCountries")
    Country get();
}
