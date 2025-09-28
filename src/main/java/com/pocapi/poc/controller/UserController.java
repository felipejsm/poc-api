package com.pocapi.poc.controller;

import com.pocapi.poc.model.UserMetadata;
import com.pocapi.poc.service.UserClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

    private UserClientService service;

    public UserController(final UserClientService service) {
        this.service = service;
    }
    @GetMapping("/users")
    public ResponseEntity<UserMetadata> getAll() {
        var users = this.service.getUsers();
        return ResponseEntity.ok(users);
    }
}
