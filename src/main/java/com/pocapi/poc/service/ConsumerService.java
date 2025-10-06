package com.pocapi.poc.service;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final String QUEUE_NAME = "queue.1";

    @ServiceBusListener(destination = QUEUE_NAME)
    public void handleMessageFromServiceBus(String message) {
        System.out.println("Message received: "+message);
    }
}
