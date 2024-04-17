package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.CargoCompany;
import com.itsvaske.shipping.model.Contract;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/cargocompany")
public class CargoCompanyService {

    @Inject
    private EntityManager em;

    public List<CargoCompany> getAllCargoCompaniesDB() {
        return em.createNamedQuery(CargoCompany.GET_ALL_CARGO_COMPANIES, CargoCompany.class).getResultList();
    }

    public List<CargoCompany> getContractsByNumberDB(int id) {
        return em.createNamedQuery(CargoCompany.GET_CARGO_COMPANY_CONTRACTS, CargoCompany.class).setParameter("id", id).getResultList();
    }

    public CargoCompany addCompanyDB(CargoCompany cargoCompany) {
        return em.merge(cargoCompany);
    }

    @GET
    @Path("/getAllCompanies")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContracts() {
        List<CargoCompany> companies = getAllCargoCompaniesDB();

        return Response.ok().entity(companies).build();
    }

    @GET
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractsByNumber(@QueryParam(value = "id") int id) {
        List<CargoCompany> companies = getContractsByNumberDB(id);

        return Response.ok().entity(companies).build();
    }

    @POST
    @Path("/getContractsByNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompany(CargoCompany cargoCompany) {
        CargoCompany company = addCompanyDB(cargoCompany);

        return Response.ok().entity(company).build();
    }
}
