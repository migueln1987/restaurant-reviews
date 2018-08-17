package com.example.restaurantreviews;

import com.example.restaurantreviews.models.Address;
import com.example.restaurantreviews.models.Restaurant;
import com.example.restaurantreviews.models.Review;
import com.example.restaurantreviews.models.User;
import com.example.restaurantreviews.repositories.RestaurantRepository;
import com.example.restaurantreviews.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddToDB implements CommandLineRunner {

    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    public AddToDB(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Restaurant chilis = new Restaurant("Chilis",
                new Address("123 Main Street", "Chicago", "Illinois"),
                Arrays.asList(
                        new Review(new User("User123", "user123@gmail.com"), 4, "Great Restaurant"),
                        new Review(new User("User234", "user234@gmail.com"), 5, "Awesome Restaurant"),
                        new Review(new User("User987", "user987@gmail.com"), 5, "Food was good")
                )
        );
        Restaurant redRobbin = new Restaurant("Red Robin",
                new Address("654 Main Street", "Niles", "Illinois"),
                Arrays.asList(
                        new Review(new User("User432", "user432@gmail.com"), 4, "Great Restaurant"),
                        new Review(new User("User234", "user234@gmail.com"), 4, "OK Restaurant"),
                        new Review(new User("User653", "user653@gmail.com"), 4, "Food was OK")
                )
        );

        this.restaurantRepository.deleteAll();
        this.userRepository.deleteAll();
        List<Restaurant> restaurants = Arrays.asList(chilis, redRobbin);
        restaurants.forEach(
                restaurant -> restaurant.getReviews().forEach(
                        review -> {
                            User user = review.getUser();
                            this.userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
                                user.setNumOfReviews(u.getNumOfReviews() + 1);
                                this.userRepository.delete(u);
                            });
                            this.userRepository.save(user);
                        }));
        this.restaurantRepository.saveAll(restaurants);
    }
}
