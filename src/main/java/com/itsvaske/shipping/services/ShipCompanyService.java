package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Contract;
import com.itsvaske.shipping.model.Ship;
import com.itsvaske.shipping.model.ShipCompany;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/shipcompany")
public class ShipCompanyService {

    @Inject
    private EntityManager em;

    public List<ShipCompany> getAllShipCompaniesDB() {
        return em.createNamedQuery(ShipCompany.GET_ALL_SHIP_COMPANIES, ShipCompany.class).getResultList();
    }

    public List<Contract> getContractsByIdDB(int id) {
        return em.createNamedQuery(ShipCompany.GET_CONTRACTS_FOR_COMPANY, Contract.class).setParameter("id", id).getResultList();
    }

    public List<Ship> getShipsForCompanyDB(int id) {
        return em.createNamedQuery(ShipCompany.GET_SHIPS_FOR_COMPANY, Ship.class).setParameter("id", id).getResultList();
    }

    public ShipCompany addCompanyDB(ShipCompany sh) {
        return em.merge(sh);
    }

    @GET
    @Path("/getAllCompanies")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCompanies() {
        List<ShipCompany> companies = getAllShipCompaniesDB();

        return Response.ok().entity(companies).build();
    }

    @GET
    @Path("/getContractsById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractsById(@QueryParam(value = "id") int id) {
        List<Contract> companies = getContractsByIdDB(id);

        return Response.ok().entity(companies).build();
    }

    @GET
    @Path("/getShipsById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getShipsById(@QueryParam(value = "id") int id) {
        List<Ship> companies = getShipsForCompanyDB(id);

        return Response.ok().entity(companies).build();
    }

    @POST
    @Path("/addShipCompany")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShipCompany(ShipCompany sh) {
        ShipCompany shipCompany = addCompanyDB(sh);

        return Response.ok().entity(shipCompany).build();
    }
}
