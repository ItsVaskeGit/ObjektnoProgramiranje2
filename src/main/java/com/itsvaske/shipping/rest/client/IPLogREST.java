package com.itsvaske.shipping.rest.client;

import com.itsvaske.shipping.model.IPLog;
import com.itsvaske.shipping.proxies.IPClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/ipLogREST")
public class IPLogREST {

    @RestClient
    private IPClient ipClient;

    public IPLog getIPOfEmployee() {
        return ipClient.get();
    }

    @Path("/getIP")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIP() {
        IPLog ipLog = ipClient.get();
        return Response.ok().entity(ipLog).build();
    }
}
