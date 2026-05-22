package com.anastDev.vegan_finder.service;

import com.anastDev.vegan_finder.core.exceptions.EntityAlreadyExistsException;
import com.anastDev.vegan_finder.core.exceptions.EntityInvalidArgumentException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotFoundException;
import com.anastDev.vegan_finder.dto.SavedRestaurantInsertDTO;
import com.anastDev.vegan_finder.dto.SavedRestaurantReadOnlyDTO;
import com.anastDev.vegan_finder.model.SavedRestaurant;

import java.util.List;

public interface ISavedRestaurantService {

    SavedRestaurant saveRestaurant(SavedRestaurantInsertDTO dto) throws EntityNotFoundException, EntityAlreadyExistsException;
    List<SavedRestaurantReadOnlyDTO> getSavedRestaurantByUserId(Long id) throws EntityNotFoundException;
    List<SavedRestaurantReadOnlyDTO> getSavedRestaurantByRestaurantId(Long id) throws EntityNotFoundException;
    SavedRestaurantReadOnlyDTO unsaveRestaurant(Long id, String username) throws EntityNotFoundException, EntityInvalidArgumentException;
}
