package com.anastDev.vegan_finder.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequestDTO (
        @NotNull String username,
        @NotNull String password
) {}