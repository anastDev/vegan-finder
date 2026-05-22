package com.anastDev.vegan_finder.repository;

import com.anastDev.vegan_finder.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByName(String name);
    Optional<Restaurant> findByNameAndAddress(String name, String address);
}
