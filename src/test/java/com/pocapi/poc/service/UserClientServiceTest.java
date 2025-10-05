package com.pocapi.poc.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocapi.poc.client.UserClient;
import com.pocapi.poc.model.UserMetadata;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserClientServiceTest {

    @InjectMocks
    UserClientService userClientService;
    @Mock
    UserClient userClient;

    String jsonData = """
            {
              "page": 0,
              "per_page": 0,
              "total": 0,
              "total_pages": 0,
              "data": [
                {
                  "id": 0,
                  "email": "string",
                  "first_name": "string",
                  "last_name": "string",
                  "avatar": "string"
                }
              ]
            }
            """;
    ObjectMapper objectMapper;

    @Test
    void getUsers() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        UserMetadata user = objectMapper.readValue(jsonData, UserMetadata.class);
        when(userClient.getUsers()).thenReturn(user);
        UserMetadata users = userClientService.getUsers();
        assertNotNull(users);
    }
    
}
