package com.anastDev.vegan_finder.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SavedRestaurantInsertDTO {
    @NotNull
    private String userUuid;

    @NotNull
    private Long restaurantId;
}
