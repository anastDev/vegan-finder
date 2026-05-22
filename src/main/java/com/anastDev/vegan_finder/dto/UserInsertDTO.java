package com.anastDev.vegan_finder.dto;

import com.anastDev.vegan_finder.core.enums.GenderType;
import com.anastDev.vegan_finder.core.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserInsertDTO(
        @NotBlank(message = "Firstname is required")
        String firstname,

    @NotEmpty(message = "Lastname is required")
    String lastname,

    @NotBlank(message = "Username is required")
    String username,

        @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email")
        String email,

    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)(?=.*?[@#$!%&*]).{8,}$",
        message = "Invalid Password")
    String password,

    @NotNull(message = "Date of birth is required")
        LocalDate dateOfBirth,

    @NotNull(message = "Gender is required")
        GenderType gender,

    @NotNull(message = "Role is required")
        Role role
) {}
