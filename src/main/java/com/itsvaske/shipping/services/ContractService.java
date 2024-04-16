package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Contract;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/contracts")
public class ContractService {

    @Inject
    private EntityManager em;

    public List<Contract> getAllContractsDB() {
        return em.createNamedQuery(Contract.GET_ALL_CONTRACTS, Contract.class).getResultList();
    }

    public List<Contract> getContractsByNumberDB(int number) {
        return em.createNamedQuery(Contract.GET_CONTRACTS_BY_NUMBER, Contract.class).setParameter("number", number).getResultList();
    }

    @GET
    @Path("/getAllContracts")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContracts() {
        List<Contract> contracts = getAllContractsDB();

        return Response.ok().entity(contracts).build();
    }

    @GET
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractsByNumber(@QueryParam(value = "number") int number) {
        List<Contract> contracts = getContractsByNumberDB(number);

        return Response.ok().entity(contracts).build();
    }
}
