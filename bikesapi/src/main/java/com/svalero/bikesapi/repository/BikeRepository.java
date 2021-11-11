package com.svalero.bikesapi.repository;

import com.svalero.bikesapi.domain.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {

    List<Bike> findAll();


    // Bike deleteBikeById(long id);
    List<Bike> findByStationId(int stationId);
    // List<Bike> findByBabyChair(boolean babyChair);
    // List<Bike> findByBatteryGreaterThan(int battery);

}
