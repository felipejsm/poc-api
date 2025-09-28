package com.pocapi.poc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocapi.poc.model.UserMetadata;
import com.pocapi.poc.service.UserClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    UserClientService service;

    @Mock
    UserController controller;

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
    void shouldCallUserControllerAndGetAllUserMetadata() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        UserMetadata user = objectMapper.readValue(jsonData, UserMetadata.class);
        when(service.getUsers()).thenReturn(user);
        ResponseEntity response = controller.getAll();
        assertEquals(ResponseEntity.ok(), response.getStatusCode());
    }
}
