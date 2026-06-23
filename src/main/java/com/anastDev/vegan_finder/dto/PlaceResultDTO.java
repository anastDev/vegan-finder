package com.anastDev.vegan_finder.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record PlaceResultDTO(
        String id,
        DisplayName displayName,
        String formattedAddress,
        Location location,
        Double rating,
        Integer userRatingCount,
        String websiteUri,
        List<Photo> photos,
        String priceLevel,
        OpeningHours currentOpeningHours,
        String nationalPhoneNumber,
        Boolean servesVegetarianFood,
        Boolean servesCoffee,
        Boolean servesBreakfast,
        Boolean servesBrunch,
        Boolean servesCocktails,
        Boolean servesDinner
) {
    public record Photo(String name, Integer widthPX, Integer heightPx){}

    public record DisplayName(String text) {}

    public record Location(Double latitude, Double longitude) {}

    public record OpeningHours(Boolean openNow) {}
}
