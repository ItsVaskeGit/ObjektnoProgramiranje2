package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Log.GET_ALL_LOGS, query = "select l from Log l"),
        @NamedQuery(name = Log.GET_LOG_BY_IP, query = "select l from Log l where l.ipLog.ipString = :ip"),
        @NamedQuery(name = Log.GET_LOG_BY_API, query = "select l from Log l where l.apiUsed = :api"),
        @NamedQuery(name = Log.GET_LOG_BY_ID, query = "select l from Log l where l.id = :id")
})
public class Log {

    public static final String GET_ALL_LOGS = "getAllLogs";
    public static final String GET_LOG_BY_IP = "getLogByIP";
    public static final String GET_LOG_BY_API = "getLogByAPI";
    public static final String GET_LOG_BY_ID = "getLogByID";

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private IPLog ipLog;

    private String apiUsed;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
