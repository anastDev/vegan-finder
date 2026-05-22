package com.anastDev.vegan_finder.dto;

import lombok.Builder;

@Builder
public record UserReadOnlyDTO(
        String firstname, String lastname, String uuid
) {}