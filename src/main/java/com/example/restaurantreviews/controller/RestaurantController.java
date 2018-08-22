package com.example.restaurantreviews.controller;

import com.example.restaurantreviews.models.Restaurant;
import com.example.restaurantreviews.repositories.RestaurantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "*") //TODO change me!
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/all")
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    @GetMapping("/{name}")
    public Optional<Restaurant> getByName(@PathVariable("name") String name) {
        Optional<Restaurant> restaurant = restaurantRepository.findByName(name);
        return restaurant;
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getById(@PathVariable("id") String id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant;
    }



}
