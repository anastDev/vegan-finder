package com.anastDev.vegan_finder.repository;

import com.anastDev.vegan_finder.model.Restaurant;
import com.anastDev.vegan_finder.model.SavedRestaurant;
import com.anastDev.vegan_finder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavedRestaurantRespository extends JpaRepository<SavedRestaurant, Long> {

    List<SavedRestaurant> findByUser(User user);
    List<SavedRestaurant> findByRestaurant(Restaurant restaurant);
    Optional<SavedRestaurant> findByUserAndRestaurant(User user, Restaurant restaurant);
}
