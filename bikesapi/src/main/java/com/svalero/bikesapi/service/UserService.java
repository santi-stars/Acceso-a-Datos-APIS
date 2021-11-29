package com.svalero.bikesapi.service;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.User;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User findUser(long id)throws UserNotFoundException;

    User addUser(User user);
}
