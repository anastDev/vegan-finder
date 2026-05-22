package com.anastDev.vegan_finder.dto;

import com.anastDev.vegan_finder.core.enums.GenderType;
import com.anastDev.vegan_finder.core.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserUpdateDTO(
        @NotNull
        Long id,

        @NotNull(message = "Uuid field is required")
        String uuid,

        @NotEmpty(message = "Firstname is required")
        String firstname,

        @NotEmpty(message = "Last name is required")
        String lastname,

        @NotEmpty(message = "Username is required")
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
