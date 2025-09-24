package com.pocapi.poc.client;

import com.pocapi.poc.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "userClient", url = "https://reqres.in/api")
public interface UserClient {
    @GetMapping("/users")
    List<User> getUsers();
}
