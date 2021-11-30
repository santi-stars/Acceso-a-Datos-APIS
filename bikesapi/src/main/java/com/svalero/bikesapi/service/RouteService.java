package com.svalero.bikesapi.service;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.Route;
import com.svalero.bikesapi.domain.User;
import com.svalero.bikesapi.domain.dto.RouteDTO;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.UserNotFoundException;

import java.util.List;

public interface RouteService {

    List<Route> findAllRoutes();
    Route addRoute(RouteDTO routeDTO) throws UserNotFoundException, BikeNotFoundException;
    List<Route>findRoutes(Bike bike, int distance);
    List<Route>findRoutes(Bike bike);
}
