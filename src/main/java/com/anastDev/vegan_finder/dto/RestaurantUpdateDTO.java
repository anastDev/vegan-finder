package com.anastDev.vegan_finder.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantUpdateDTO {

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String address;

    @NotNull
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double lat;

    @NotNull
    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double lng;

    @NotNull
    private Double rating;

    @NotBlank
    @Size(max = 200)
    private String websiteUri;

    @NotBlank
    private Boolean veganFriendly;
}
