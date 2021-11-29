package com.svalero.bikesapi.service;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.Route;
import com.svalero.bikesapi.domain.User;
import com.svalero.bikesapi.domain.dto.RouteDTO;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.UserNotFoundException;
import com.svalero.bikesapi.repository.BikeRepository;
import com.svalero.bikesapi.repository.RouteRepository;
import com.svalero.bikesapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Route> findAllUsers() {
        return null;
    }

    @Override
    public List<Route> findByUsers() {
        return null;
    }

    @Override
    public Route addRoute(RouteDTO routeDTO) throws UserNotFoundException, BikeNotFoundException {
        User user = userRepository.findById(routeDTO.getUser()).orElseThrow(UserNotFoundException::new);
        Bike bike = bikeRepository.findById(routeDTO.getBike()).orElseThrow(BikeNotFoundException::new);

        // Con el mapper el cual está insertado en el POM.XML hace automáticamente el get... y set... para
        // mandar el objeto Route que consta de sus atributos directos de bikeId y userId de Bike y User

        ModelMapper mapper = new ModelMapper();
        Route route = mapper.map(routeDTO, Route.class);
        route.setBike(bike);
        route.setUser(user);
        return routeRepository.save(route);
    }
}
