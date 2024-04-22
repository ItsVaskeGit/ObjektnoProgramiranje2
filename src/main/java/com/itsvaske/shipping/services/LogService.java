package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Log;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Dependent
public class LogService {

    @Inject
    private EntityManager em;

    @Transactional
    public Log addLog(Log log) {
        return em.merge(log);
    }

    public List<Log> getAllLogs() {
        return em.createNamedQuery(Log.GET_ALL_LOGS, Log.class).getResultList();
    }

    public List<Log> getLogByIP(String ip) {
        return em.createNamedQuery(Log.GET_LOG_BY_IP, Log.class).setParameter("ip", ip).getResultList();
    }

    public List<Log> getLogByAPI(String api) {
        return em.createNamedQuery(Log.GET_LOG_BY_API, Log.class).setParameter("api", api).getResultList();
    }

    public List<Log> getLogByID(int id) {
        return em.createNamedQuery(Log.GET_LOG_BY_ID, Log.class).setParameter("id", id).getResultList();
    }
}
