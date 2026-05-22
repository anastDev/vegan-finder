package com.anastDev.vegan_finder.dto;

public record ResponseMessageDTO(String code, String description){

    public ResponseMessageDTO(String code) {
        this(code, "");
    }
}
