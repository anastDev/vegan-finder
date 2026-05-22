package com.anastDev.vegan_finder.dto;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SavedRestaurantReadOnlyDTO{

    private Long id;
    private String uuid;
    private String username;
    private String firstname;
    private String lastname;
    private String restaurantName;
    private String address;
    private Boolean veganFriendly;
}
