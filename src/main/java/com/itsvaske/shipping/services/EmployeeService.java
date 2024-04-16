package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Employee;
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

    public List<Employee> getAllEmployeesDB() {
        return em.createNamedQuery(Employee.GET_ALL_EMPLOYEES, Employee.class).getResultList();
    }

    public List<Employee> getEmployeesByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_EMPLOYEES_BY_SHIP, Employee.class).setParameter("ship_id", id).getResultList();
    }

    public List<Employee> getWorkers() {
        return em.createNamedQuery(Employee.GET_WORKERS, Employee.class).getResultList();
    }

    public List<Employee> getOfficers() {
        return em.createNamedQuery(Employee.GET_OFFICERS, Employee.class).getResultList();
    }

    public List<Employee> getMachinists() {
        return em.createNamedQuery(Employee.GET_MACHINISTS, Employee.class).getResultList();
    }

    public List<Employee> getElectricians() {
        return em.createNamedQuery(Employee.GET_ELECTRICIANS, Employee.class).getResultList();
    }

    public List<Employee> getCornelians() {
        return em.createNamedQuery(Employee.GET_CORNELIANS, Employee.class).getResultList();
    }

    public Employee addEmployeeDB(Employee e) {
        return em.merge(e);
    }

    @GET
    @Path("/getEmployeesByShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeesByShip(@QueryParam(value = "id") int id) {
        List<Employee> employeesForShip = getEmployeesByShipDB(id);

        return Response.ok().entity(employeesForShip).build();
    }

    @GET
    @Path("/getAllEmployees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        List<Employee> employees = getAllEmployeesDB();

        return Response.ok().entity(employees).build();
    }

    @GET
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee e) {
        Employee em = addEmployeeDB(e);

        return Response.ok().entity(em).build();
    }
}
