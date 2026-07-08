package com.anastDev.vegan_finder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PhotoResponse(String photoUri) {
}
