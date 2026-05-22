package com.anastDev.vegan_finder.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantReadOnlyDTO {

    private Long id;
    private String name;
    private String address;
    private Double lat;
    private Double lng;
    private Boolean isVeganFriendly;
    private Instant createdAt;
    private Instant updatedAt;
}
