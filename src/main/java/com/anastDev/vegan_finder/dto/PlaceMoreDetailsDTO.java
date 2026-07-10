package com.anastDev.vegan_finder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlaceMoreDetailsDTO(
        List<Review> reviews
) {
    public record Review(
            String name,
            Integer rating,
            LocalizedText text,
            LocalizedText originalText,
            AuthorAttribution authorAttribution,
            String relativePublishTimeDescription,
            String publishTime,
            String googleMapsUri
    ) {}

    public record LocalizedText(
            String text,
            String languageCode
    ) {}
    public record AuthorAttribution(
            String displayName,
            String uri,
            String photoUri
    ) {}
}
