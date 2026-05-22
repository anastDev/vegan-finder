package com.anastDev.vegan_finder.service;

import com.anastDev.vegan_finder.core.exceptions.EntityAlreadyExistsException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotAuthorizedException;
import com.anastDev.vegan_finder.core.exceptions.EntityNotFoundException;
import com.anastDev.vegan_finder.dto.RestaurantInsertDTO;
import com.anastDev.vegan_finder.dto.RestaurantReadOnlyDTO;
import com.anastDev.vegan_finder.dto.RestaurantUpdateDTO;
import com.anastDev.vegan_finder.mapper.Mapper;
import com.anastDev.vegan_finder.model.Restaurant;
import com.anastDev.vegan_finder.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final Mapper mapper;

    @Override
    @Transactional(rollbackOn = EntityAlreadyExistsException.class)
    public Restaurant saveRestaurant(RestaurantInsertDTO dto) throws EntityAlreadyExistsException {
        try{

            if (restaurantRepository.findByNameAndAddress(dto.getName(), dto.getAddress()).isPresent()) {
                throw new EntityAlreadyExistsException(
                        "Restaurant",
                        "Restaurant already exists with name " + dto.getName() + " and address " + dto.getAddress()
                );
            }

            Restaurant restaurant = mapper.mapToRestaurantEntity(dto);
            restaurantRepository.save(restaurant);

            log.info("Restaurant saved: {}", dto.getName());
            return restaurant;
        } catch (EntityAlreadyExistsException e) {
            log.error("Save failed for book with name={}, Restaurant already exists.", dto.getName(), e);
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = {EntityAlreadyExistsException.class, EntityNotFoundException.class})
    public void updateRestaurant(RestaurantUpdateDTO dto) throws EntityAlreadyExistsException, EntityNotFoundException {
        try{
            Restaurant restaurant = restaurantRepository.findByNameAndAddress(dto.getName(), dto.getAddress())
                    .orElseThrow(() -> new EntityNotFoundException("Restaurant", "Restaurant not found"));

            if(!restaurant.getName().equals(dto.getName()) && !restaurant.getAddress().equals(dto.getAddress())) {
                if (restaurantRepository.findByNameAndAddress(dto.getName(), dto.getAddress()).isPresent()) {
                    throw new EntityAlreadyExistsException("Restaurant", "Restaurant with name " + dto.getName() + " and address " + dto.getAddress() + " already exists.");
                }
                restaurant.setName(dto.getName());
                restaurant.setAddress(dto.getAddress());
            }

            restaurant.setName(dto.getName());
            restaurant.setAddress(dto.getAddress());
            restaurant.setLat(dto.getLat());
            restaurant.setLng(dto.getLng());
            restaurant.setVeganFriendly(dto.getVeganFriendly());

            restaurantRepository.save(restaurant);
            log.info("Restaurant with name={} updated!", dto.getName());
        } catch (EntityNotFoundException e) {
            log.error("Update failed for restaurant with name={} and address={}. Entity not found.", dto.getName(), dto.getAddress());
            throw e;
        } catch (EntityAlreadyExistsException e) {
            log.error("Update failed for restaurant with name={} and address={}. Entity already exists.", dto.getName(), dto.getAddress());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = EntityNotAuthorizedException.class)
    public void deleteById(Long id) throws EntityNotFoundException {
        try {
            Restaurant restaurant = restaurantRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Restaurant", "Restaurant with Id:" + id + " not found!"));

            restaurantRepository.deleteById(restaurant.getId());
            log.info("Restaurant with Id={} deleted!", id);
        } catch (EntityNotFoundException e ){
            log.error("Delete failed for restaurant with Id={}. Restaurant not found.", id, e);
            throw e;
        }
    }

    @Override
    public Page<RestaurantReadOnlyDTO> getRestaurants(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageable);
        log.debug("Get Paginated restaurants were returned successfully with page={} and size={}", page, size);
        return restaurantPage.map(mapper::mapToRestaurantReadOnlyDTO);
    }
}
