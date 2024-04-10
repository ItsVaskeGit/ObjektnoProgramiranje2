package com.itsvaske.shipping.rest;

import com.itsvaske.shipping.model.Country;
import com.itsvaske.shipping.proxies.CountryProxy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Path("/country")
public class CountryRESTResource {

    @RestClient
    private CountryProxy proxy;
    private List<Country> countries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContries() {
        Country country = proxy.get();
        countries.add(country);
        return Response.ok().entity(countries).build();
    }
}
