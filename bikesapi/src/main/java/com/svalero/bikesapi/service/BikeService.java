package com.svalero.bikesapi.service;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.exception.BikeNotFoundException;

import java.util.List;

public interface BikeService {
    // Esto es una INTERFACE para luego implementar estos métodos en BikeServiceImpl.java
    List<Bike> findAllBikes();

    List<Bike> findAllBikes(int stationId);

    Bike findBike(long id) throws BikeNotFoundException;

    Bike deleteBike(long id) throws BikeNotFoundException;

    Bike addBike(Bike bike);

    Bike modifyBike(long id, Bike bike) throws BikeNotFoundException;

    void repairBike(Bike bike);


}
