package com.anastDev.vegan_finder.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponseDTO(
        String firstname,
        String lastname,
        String token
) {
}
