package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.model.Contract;
import com.itsvaske.shipping.model.Ship;
import com.itsvaske.shipping.model.ShipCompany;
import com.itsvaske.shipping.services.ShipCompanyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/shipcompany")
public class ShipCompanyREST {

    @Inject
    ShipCompanyService shipCompanyService;

    @GET
    @Path("/getAllCompanies")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCompanies() {
        List<ShipCompany> companies = shipCompanyService.getAllShipCompaniesDB();

        return Response.ok().entity(companies).build();
    }

    @GET
    @Path("/getContractsById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractsById(@QueryParam(value = "id") int id) {
        List<Contract> companies = shipCompanyService.getContractsByIdDB(id);

        return Response.ok().entity(companies).build();
    }

    @GET
    @Path("/getShipsById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getShipsById(@QueryParam(value = "id") int id) {
        List<Ship> companies = shipCompanyService.getShipsForCompanyDB(id);

        return Response.ok().entity(companies).build();
    }

    @POST
    @Path("/addShipCompany")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShipCompany(ShipCompany sh) {
        ShipCompany shipCompany = shipCompanyService.addCompanyDB(sh);

        return Response.ok().entity(shipCompany).build();
    }
}
