package com.itsvaske.shipping.proxies;

import com.itsvaske.shipping.model.IPLog;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api-bdc.net/")
public interface IPClient {

    @GET
    @Path("/client-ip")
    IPLog get();
}
