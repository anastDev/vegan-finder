package com.anastDev.vegan_finder.core.exceptions;

public class AppObjectNotAuthorizedException extends EntityGenericException {
  private static final String DEFAULT_CODE = "NotAuthorized";

  public AppObjectNotAuthorizedException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
