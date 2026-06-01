package com.anastDev.vegan_finder.service;

import com.anastDev.vegan_finder.core.exceptions.EntityAlreadyExistsException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotFoundException;
import com.anastDev.vegan_finder.dto.PlaceResultDTO;
import com.anastDev.vegan_finder.dto.RestaurantInsertDTO;
import com.anastDev.vegan_finder.dto.RestaurantReadOnlyDTO;
import com.anastDev.vegan_finder.dto.RestaurantUpdateDTO;
import com.anastDev.vegan_finder.model.Restaurant;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRestaurantService {

    Restaurant saveRestaurant(RestaurantInsertDTO dto) throws EntityAlreadyExistsException;
    void updateRestaurant(RestaurantUpdateDTO dto) throws EntityAlreadyExistsException, EntityNotFoundException;
    void deleteById(Long id) throws EntityNotFoundException;
    Page<RestaurantReadOnlyDTO> getRestaurants(int page, int size);
    List<PlaceResultDTO> findVegetarianRestaurantNearby(double lat, double lng, int radiusMetres);
}
