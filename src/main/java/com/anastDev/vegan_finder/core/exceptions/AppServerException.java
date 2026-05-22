package com.anastDev.vegan_finder.core.exceptions;

public class AppServerException extends EntityGenericException {

    public AppServerException(String code, String message) {
        super(code, message);
    }
}
