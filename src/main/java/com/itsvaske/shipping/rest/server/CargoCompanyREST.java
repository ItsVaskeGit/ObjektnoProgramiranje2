package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.interfaces.LogMechanism;
import com.itsvaske.shipping.model.CargoCompany;
import com.itsvaske.shipping.services.CargoCompanyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/cargocompany")
public class CargoCompanyREST {

    @Inject
    private CargoCompanyService cargoCompanyService;

    @GET
    @Path("/getAllCompanies")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContracts() {
        List<CargoCompany> companies = cargoCompanyService.getAllCargoCompaniesDB();

        return Response.ok().entity(companies).build();
    }

    @GET
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractsByNumber(@QueryParam(value = "id") int id) {
        List<CargoCompany> companies = cargoCompanyService.getContractsByNumberDB(id);

        return Response.ok().entity(companies).build();
    }

    @POST
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompany(CargoCompany cargoCompany) {
        CargoCompany company = cargoCompanyService.addCompanyDB(cargoCompany);

        return Response.ok().entity(company).build();
    }
}
