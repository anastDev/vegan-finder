package com.anastDev.vegan_finder.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RestaurantApiResponse(
        List<PlaceResultDTO> places
) {}
