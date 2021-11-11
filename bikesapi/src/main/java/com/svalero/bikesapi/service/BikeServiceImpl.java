package com.svalero.bikesapi.service;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Bike> findAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public List<Bike> findAllBikes(int stationId) {
        return bikeRepository.findByStationId(stationId);
    }

    @Override
    public Bike findBike(long id) throws BikeNotFoundException {
        return bikeRepository.findById(id)
                .orElseThrow(BikeNotFoundException::new);
    }

    @Override
    public Bike deleteBike(long id) throws BikeNotFoundException {
        Bike bike = bikeRepository.findById(id) // Busca la bici por ID, si está la asocia al objeto y si no...
                .orElseThrow(BikeNotFoundException::new);
        // Si no devuelve una bici, arroja: la excepcion que creamos con mensaje
        bikeRepository.delete(bike);
        return bike;
    }

    @Override
    public Bike addBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public Bike modifyBike(long id, Bike newBike) throws BikeNotFoundException {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(BikeNotFoundException::new);
        bike.setAvailable(newBike.isAvailable());
        bike.setBabyChair(newBike.isBabyChair());
        bike.setBattery(newBike.getBattery());
        bike.setKilometers(newBike.getKilometers());
        bike.setStationId(newBike.getStationId());

        return bikeRepository.save(bike);
    }

    @Override
    public void repairBike(Bike bike) {

    }
}
