package com.anastDev.vegan_finder.controllers;

import com.anastDev.vegan_finder.dto.PlaceResultDTO;
import com.anastDev.vegan_finder.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/nearby")
    public ResponseEntity<List<PlaceResultDTO>> getNearbyRestaurants(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "2000") int radius
    ) {
        List<PlaceResultDTO> results = restaurantService.findVegetarianRestaurantNearby(lat, lng, radius);
        return ResponseEntity.ok(results);
    }
}
