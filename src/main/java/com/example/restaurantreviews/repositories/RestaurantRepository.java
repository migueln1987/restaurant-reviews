package com.example.restaurantreviews.repositories;

import com.example.restaurantreviews.models.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    Optional<Restaurant> findByName(String name);
}
