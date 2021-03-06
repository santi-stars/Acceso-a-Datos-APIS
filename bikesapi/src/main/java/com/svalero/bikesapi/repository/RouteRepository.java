package com.svalero.bikesapi.repository;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.Route;
import com.svalero.bikesapi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

    List<Route>findAll();
    List<Route>findByBike(Bike bike);

    List<Route> findByBikeAndKilometers(Bike bike, int kilometers);
}
