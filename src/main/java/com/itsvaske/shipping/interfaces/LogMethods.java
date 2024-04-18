package com.itsvaske.shipping.interfaces;

import com.itsvaske.shipping.model.Log;
import com.itsvaske.shipping.services.LogService;
import io.vertx.ext.web.RoutingContext;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


@LogMechanism
@Priority(2020)
@Interceptor
public class LogMethods {

    private static final Logger LOGGER = Logger.getLogger(LogMethods.class.getName());

    @Inject
    private LogService logService;

    @Inject
    private RoutingContext routingContext;

    @AroundInvoke
    public Object logMethodEntry(InvocationContext context) throws Exception {
        Date currentDateAndTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateAndTime = dateFormat.format(currentDateAndTime);
        String methodName = context.getTarget().getClass().getName() + "." + context.getMethod().getName();
        String ipAddress = routingContext.request().remoteAddress().host();
        try {
            Log log = new Log(dateAndTime, ipAddress, methodName);
            logService.addLog(log);
            return context.proceed();
        } finally {
            LOGGER.exiting(context.getTarget().getClass().getName(), context.getMethod().getName());
        }

    }
}
