package com.svalero.bikesapi.repository;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User>findAll();
}
