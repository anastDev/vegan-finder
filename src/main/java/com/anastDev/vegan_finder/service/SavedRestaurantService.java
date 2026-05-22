package com.anastDev.vegan_finder.service;

import com.anastDev.vegan_finder.core.exceptions.EntityAlreadyExistsException;
import com.anastDev.vegan_finder.core.exceptions.EntityInvalidArgumentException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotFoundException;
import com.anastDev.vegan_finder.dto.SavedRestaurantInsertDTO;
import com.anastDev.vegan_finder.dto.SavedRestaurantReadOnlyDTO;
import com.anastDev.vegan_finder.mapper.Mapper;
import com.anastDev.vegan_finder.model.Restaurant;
import com.anastDev.vegan_finder.model.SavedRestaurant;
import com.anastDev.vegan_finder.model.User;
import com.anastDev.vegan_finder.repository.RestaurantRepository;
import com.anastDev.vegan_finder.repository.SavedRestaurantRespository;
import com.anastDev.vegan_finder.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SavedRestaurantService implements ISavedRestaurantService{

    private final SavedRestaurantRespository savedRestaurantRespository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    @Transactional(rollbackOn = EntityNotFoundException.class)
    public SavedRestaurant saveRestaurant(SavedRestaurantInsertDTO dto) throws EntityNotFoundException, EntityAlreadyExistsException {
       try {
           User user = userRepository.findByUuid(dto.getUserUuid())
                   .orElseThrow(() -> new EntityNotFoundException("User", "User with uuid " + dto.getUserUuid() + " not found."));

           Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                   .orElseThrow(() -> new EntityNotFoundException("Restaurant", "Restaurant with id " + dto.getRestaurantId() + " not found."));

           Instant createdAt = Instant.now();
           SavedRestaurant savedRestaurant = new SavedRestaurant(null, user, restaurant, createdAt);
           user.saveRestaurant(savedRestaurant);

           savedRestaurantRespository.save(savedRestaurant);
           log.info("User uuid={} saved restaurant with id={}", dto.getUserUuid(), dto.getRestaurantId());
           return savedRestaurant;
       } catch (EntityNotFoundException e) {
           log.error("Save failed. Entity not found. restaurantId={}, userId={}", dto.getRestaurantId(), dto.getUserUuid());
           throw e;
       }
    }

    @Override
    public List<SavedRestaurantReadOnlyDTO> getSavedRestaurantByUserId(Long id) throws EntityNotFoundException {
        return List.of();
    }

    @Override
    public List<SavedRestaurantReadOnlyDTO> getSavedRestaurantByRestaurantId(Long id) throws EntityNotFoundException {
        return List.of();
    }

    @Override
    public SavedRestaurantReadOnlyDTO unsaveRestaurant(Long id, String username) throws EntityNotFoundException, EntityInvalidArgumentException {
        return null;
    }
}
