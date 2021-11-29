package com.svalero.bikesapi.controler;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.User;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.ErrorResponse;
import com.svalero.bikesapi.service.BikeService;
import com.svalero.bikesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {   //@RequestBody recibe JSon y lo convierte a objeto JAVA
        User newUser = userService.addUser(user);
        return newUser;
    }
}
