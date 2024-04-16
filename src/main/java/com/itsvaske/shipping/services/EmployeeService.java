package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.*;
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
@Path("/employees")
public class EmployeeService {

    @Inject
    EntityManager em;

    public List<Worker> getWorkersByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_WORKERS_BY_SHIP, Worker.class).setParameter("id", id).getResultList();
    }

    public List<Officer> getOfficersByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_OFFICERS_BY_SHIP, Officer.class).setParameter("id", id).getResultList();
    }

    public List<Machinist> getMachinistsByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_MACHINISTS_BY_SHIP, Machinist.class).setParameter("id", id).getResultList();
    }

    public List<Electirician> getElectriciansByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_ELECTRICIANS_BY_SHIP, Electirician.class).setParameter("id", id).getResultList();
    }

    public List<Cornelian> getCorneliansByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_CORNELIANS_BY_SHIP, Cornelian.class).setParameter("id", id).getResultList();
    }

    public List<Worker> getWorkersDB() {
        return em.createNamedQuery(Employee.GET_WORKERS, Worker.class).getResultList();
    }

    public List<Officer> getOfficersDB() {
        return em.createNamedQuery(Employee.GET_OFFICERS, Officer.class).getResultList();
    }

    public List<Machinist> getMachinistsDB() {
        return em.createNamedQuery(Employee.GET_MACHINISTS, Machinist.class).getResultList();
    }

    public List<Electirician> getElectriciansDB() {
        return em.createNamedQuery(Employee.GET_ELECTRICIANS, Electirician.class).getResultList();
    }

    public List<Cornelian> getCorneliansDB() {
        return em.createNamedQuery(Employee.GET_CORNELIANS, Cornelian.class).getResultList();
    }

    public Employee addEmployeeDB(Employee e) {
        return em.merge(e);
    }

    @GET
    @Path("/getEmployeesByShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeesByShip(@QueryParam(value = "id") int id) {
        List<Worker> workersForShip = getWorkersByShipDB(id);
        List<Officer> officers = getOfficersByShipDB(id);
        List<Machinist> machinists = getMachinistsByShipDB(id);
        List<Electirician> electiricians = getElectriciansByShipDB(id);
        List<Cornelian> cornelians = getCorneliansByShipDB(id);

        return Response.ok().entity(workersForShip).entity(officers).entity(machinists).entity(electiricians).entity(cornelians).build();
    }

    @GET
    @Path("/getAllEmployees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        List<Worker> workers = getWorkersDB();
        List<Officer> officers = getOfficersDB();
        List<Machinist> machinists = getMachinistsDB();
        List<Electirician> electricians = getElectriciansDB();
        List<Cornelian> cornelians = getCorneliansDB();

        return Response.ok().entity(workers).entity(officers).entity(machinists).entity(electricians).entity(cornelians).build();
    }

    @GET
    @Path("/getWorkers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getWorkers() {
        List<Worker> workers = getWorkersDB();

        return Response.ok().entity(workers).build();
    }

    @GET
    @Path("/getOfficers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOfficers() {
        List<Officer> officers = getOfficersDB();

        return Response.ok().entity(officers).build();
    }

    @GET
    @Path("/getMachinists")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMachinists() {
        List<Machinist> machinists = getMachinistsDB();

        return Response.ok().entity(machinists).build();
    }

    @GET
    @Path("/getElectricians")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getElectricians() {
        List<Electirician> electiricians = getElectriciansDB();

        return Response.ok().entity(electiricians).build();
    }

    @GET
    @Path("/getCornelians")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCornelians() {
        List<Cornelian> cornelians = getCorneliansDB();

        return Response.ok().entity(cornelians).build();
    }

    @GET
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee e) {
        Employee em = addEmployeeDB(e);

        return Response.ok().entity(em).build();
    }
}
