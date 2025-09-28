package com.pocapi.poc.service;

import com.pocapi.poc.client.UserClient;
import com.pocapi.poc.controller.UserController;
import com.pocapi.poc.model.User;
import com.pocapi.poc.model.UserMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClientService {

    private static final Logger logger = LoggerFactory.getLogger(UserClientService.class);
    private final UserClient userClient;

    public UserClientService(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserMetadata getUsers() {
        logger.info("[UserClientService.getUsers] Recuperando Users");
        return this.userClient.getUsers();
    }
}
