package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.model.Contract;
import com.itsvaske.shipping.services.ContractService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/contract")
public class ContractREST {

    @Inject
    private ContractService contractService;


    @GET
    @Path("/getAllContracts")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContracts() {
        List<Contract> contracts = contractService.getAllContractsDB();

        return Response.ok().entity(contracts).build();
    }

    @GET
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractsByNumber(@QueryParam(value = "number") int number) {
        List<Contract> contracts = contractService.getContractsByNumberDB(number);

        return Response.ok().entity(contracts).build();
    }
}
