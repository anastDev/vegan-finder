package com.anastDev.vegan_finder.mapper;

import com.anastDev.vegan_finder.dto.*;
import com.anastDev.vegan_finder.model.Restaurant;
import com.anastDev.vegan_finder.model.SavedRestaurant;
import com.anastDev.vegan_finder.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final PasswordEncoder passwordEncoder;

    public Restaurant mapToRestaurantEntity(RestaurantInsertDTO dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setLat(dto.getLat());
        restaurant.setLng(dto.getLng());
        restaurant.setAddress(dto.getAddress());
        restaurant.setVeganFriendly(dto.getVeganFriendly());
        return restaurant;
    }

    public RestaurantReadOnlyDTO mapToRestaurantReadOnlyDTO(Restaurant restaurant) {
        return new RestaurantReadOnlyDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getLat(),
                restaurant.getLng(),
                restaurant.getVeganFriendly(),
                restaurant.getCreatedAt(),
                restaurant.getUpdatedAt()
        );
    }

    public UserReadOnlyDTO mapToUserReadOnlyDTO(User user) {
        return new UserReadOnlyDTO(
                user.getFirstname(),
                user.getLastname(),
                user.getUuid()
        );
    }

    public User mapToUserEntity(UserInsertDTO dto) {
        User user = new User();
        user.setFirstname(dto.firstname());
        user.setLastname(dto.lastname());
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setDateOfBirth(dto.dateOfBirth());
        user.setGender(dto.gender());
        user.setRole(user.getRole());
        return user;
    }

    public User mapToUserEntity(UserUpdateDTO dto) {
        User user = new User();
        user.setFirstname(dto.firstname());
        user.setLastname(dto.lastname());
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setDateOfBirth(dto.dateOfBirth());
        user.setGender(dto.gender());
        user.setRole(user.getRole());
        return user;
    }

    public SavedRestaurantReadOnlyDTO mapToSavedRestaurantReadDTO(SavedRestaurant dto) {
        return new SavedRestaurantReadOnlyDTO (
                dto.getId(),
                dto.getUser().getUuid(),
                dto.getUser().getUsername(),
                dto.getUser().getFirstname(),
                dto.getUser().getLastname(),
                dto.getRestaurant().getName(),
                dto.getRestaurant().getAddress(),
                dto.getRestaurant().getVeganFriendly()
        );
    }
}
