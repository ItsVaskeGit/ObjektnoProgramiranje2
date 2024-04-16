package com.itsvaske.shipping.proxies;

import com.itsvaske.shipping.model.Country;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/v3")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://date.nager.at")
public interface CountryProxy {

    @GET
    @Path("/AvailableCountries")
    List<Country> get();
}