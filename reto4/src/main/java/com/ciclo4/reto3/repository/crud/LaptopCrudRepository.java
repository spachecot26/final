package com.ciclo4.reto3.repository.crud;

import com.ciclo4.reto3.model.Laptop;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;

public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {

    //Para seleccionar el producto con id maximo // Para que en el front el id se cree solo
    Optional<Laptop> findTopByOrderByIdDesc();

    Optional<Laptop> findById(int id);
    
    @Query("{price: ?0}")
    List<Laptop> findBygadgetByPrice(final double price);
}
