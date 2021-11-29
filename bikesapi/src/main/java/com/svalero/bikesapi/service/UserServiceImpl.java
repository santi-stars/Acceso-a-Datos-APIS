package com.svalero.bikesapi.service;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.User;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.UserNotFoundException;
import com.svalero.bikesapi.repository.BikeRepository;
import com.svalero.bikesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUser(long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
