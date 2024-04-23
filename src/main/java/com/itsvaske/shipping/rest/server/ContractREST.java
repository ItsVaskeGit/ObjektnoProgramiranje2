package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.Contract;
import com.itsvaske.shipping.model.Ship;
import com.itsvaske.shipping.services.ContractService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Loggable
@Path("/api/contract")
public class ContractREST {

    @Inject
    private ContractService contractService;

    @GET
    @Path("/getAllContracts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllContracts() {
        List<Contract> contracts = contractService.getAllContractsDB();

        return Response.ok().entity(contracts).build();
    }

    @GET
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractsByNumber(@QueryParam(value = "number") int number) {
        List<Contract> contracts = contractService.getContractsByNumberDB(number);

        return Response.ok().entity(contracts).build();
    }

    @GET
    @Path("/getContractedShip")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractedShip(@QueryParam("id")int id) {
        Ship ship = contractService.getContractedShip(id);

        return Response.ok().entity(ship).build();
    }

    @GET
    @Path("/getContractsByArrivalCountry")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractsByArrivalCountry(@QueryParam("name")String name) {
        List<Contract> contracts = contractService.getContractsByArrivalCountry(name);

        return Response.ok().entity(contracts).build();
    }

    @GET
    @Path("/getContractsByDepartureCountry")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractsByDepartureCountry(@QueryParam("name")String name) {
        List<Contract> contracts = contractService.getContractsByDepartureCountry(name);

        return Response.ok().entity(contracts).build();
    }
}
