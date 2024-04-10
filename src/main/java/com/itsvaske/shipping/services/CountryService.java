package com.itsvaske.shipping.services;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Path;

@Dependent
@Path("/country")
public class CountryService {

    @Inject
    EntityManager em;


}
