package com.pocapi.poc.config;

import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private static final String QUEUE_NAME = "queue.1";
    private final ServiceBusTemplate serviceBusTemplate;

    public MyBean(ServiceBusTemplate serviceBusTemplate) {
        this.serviceBusTemplate = serviceBusTemplate;
    }

    public void sender(String message) {
        this.serviceBusTemplate.sendAsync(QUEUE_NAME,
                MessageBuilder.withPayload(message).build())
                .subscribe();
    }

}