package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Country;
import com.itsvaske.shipping.model.EmployeeRole;
import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Dependent
public class EmployeeRoleService {

    @Inject
    private EntityManager em;

    public EmployeeRole addEmployeeRole(EmployeeRole employeeRole) {
        return em.merge(employeeRole);
    }

    public List<EmployeeRole> getAllEmployeeRoles() {
        return em.createNamedQuery(EmployeeRole.GET_ALL_EMPLOYEE_ROLES, EmployeeRole.class).getResultList();
    }

    public List<EmployeeRole> getEmployeeRoleByID(int id) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("id", id).getResultList();
    }

    public List<EmployeeRole> getEmployeeRoleByDescription(String description) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("description", description).getResultList();
    }

    public EmployeeRole getEmployeeRoleByDescriptionSingle(String description) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("description", description.toLowerCase()).getSingleResult();
    }

    @Startup
    @Transactional
    public void refreshEmployeeRolesDB() {
        EmployeeRole cornelian = new EmployeeRole();
        cornelian.setId(Long.parseLong("1"));
        cornelian.setDescription("cornelian");
        EmployeeRole electrician = new EmployeeRole();
        electrician.setId(Long.parseLong("2"));
        electrician.setDescription("electrician");
        EmployeeRole machinist = new EmployeeRole();
        machinist.setId(Long.parseLong("3"));
        machinist.setDescription("machinist");
        EmployeeRole officer = new EmployeeRole();
        officer.setId(Long.parseLong("4"));
        officer.setDescription("officer");
        EmployeeRole worker = new EmployeeRole();
        worker.setId(Long.parseLong("5"));
        officer.setDescription("worker");
        addEmployeeRole(cornelian);
        addEmployeeRole(electrician);
        addEmployeeRole(machinist);
        addEmployeeRole(officer);
        addEmployeeRole(worker);
    }
}
