package com.pocapi.poc.service;

import com.pocapi.poc.client.UserClient;
import com.pocapi.poc.model.User;
import com.pocapi.poc.model.UserMetadata;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClientService {

    private final UserClient userClient;

    public UserClientService(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserMetadata getUsers() {
        return this.userClient.getUsers();
    }
}
