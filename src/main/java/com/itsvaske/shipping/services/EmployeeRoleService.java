package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.EmployeeRole;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Dependent
public class EmployeeRoleService {

    @Inject
    private EntityManager em;

    public List<EmployeeRole> getAllEmployeeRoles() {
        return em.createNamedQuery(EmployeeRole.GET_ALL_EMPLOYEE_ROLES, EmployeeRole.class).getResultList();
    }

    public List<EmployeeRole> getEmployeeRoleByID(int id) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("id", id).getResultList();
    }

    public List<EmployeeRole> getEmployeeRoleByDescription(String description) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("description", description).getResultList();
    }
}
