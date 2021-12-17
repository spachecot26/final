package com.ciclo4.reto3.repository.crud;

import com.ciclo4.reto3.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    @Query("{monthBirthtDay: ?0}")
    List<User> findByMonthBirthtDay(final String monthBirthtDay);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findTopByOrderByIdDesc();

}
