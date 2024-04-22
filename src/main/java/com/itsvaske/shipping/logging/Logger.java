package com.itsvaske.shipping.logging;

import com.itsvaske.shipping.model.Log;
import com.itsvaske.shipping.proxies.IPClient;
import com.itsvaske.shipping.services.LogService;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.text.SimpleDateFormat;
import java.util.Date;

@Loggable
@Interceptor
@Priority(1)
public class Logger {

    @RestClient
    IPClient ipClient;

    @Inject
    LogService logService;

    @AroundInvoke
    public Object logMethodEntry(InvocationContext context) throws Exception {
        Date currentDateAndTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateAndTime = dateFormat.format(currentDateAndTime);
        String methodName = context.getTarget().getClass().getName() + "." + context.getMethod().getName();
        String ipAddress = ipClient.get().getIpString();

        Log log = new Log(dateAndTime, ipAddress, methodName);
        logService.addLog(log);
        return context.proceed();
    }

}
