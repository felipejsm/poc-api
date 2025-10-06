package com.pocapi.poc.controller;

import com.pocapi.poc.config.MyBean;
import com.pocapi.poc.model.UserMetadata;
import com.pocapi.poc.service.UserClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserClientService service;
    private MyBean myBean;

    public UserController(final UserClientService service,
                          final MyBean myBean) {
        this.service = service;
        this.myBean = myBean;
    }
    @GetMapping("/users")
    public ResponseEntity<UserMetadata> getAll() {
        logger.info("Endpoint chamado");
        var users = this.service.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/hi")
    public ResponseEntity<Void> sayHi(@RequestParam String message) {
        this.myBean.sender(message);
        return ResponseEntity.accepted().build();
    }

}
