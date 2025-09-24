package com.pocapi.poc.service;

import java.util.List;

import com.pocapi.poc.client.UserClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.pocapi.poc.model.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserClientServiceTest {

    UserClientService service;
    @InjectMocks
    UserClient userClientService;
    @BeforeEach
    void init() {
        service = new UserClientService(userClientService);
    }
    @Test
    void getUsers() {
        List<User> users = service.getUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
    
}
