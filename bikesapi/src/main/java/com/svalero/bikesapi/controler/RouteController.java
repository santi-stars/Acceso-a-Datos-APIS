package com.svalero.bikesapi.controler;

import com.svalero.bikesapi.domain.Route;
import com.svalero.bikesapi.domain.dto.RouteDTO;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.UserNotFoundException;
import com.svalero.bikesapi.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/routes")
    public Route addRoute(@RequestBody RouteDTO routeDTO) throws UserNotFoundException, BikeNotFoundException {
        return routeService.addRoute(routeDTO);
    }
}
