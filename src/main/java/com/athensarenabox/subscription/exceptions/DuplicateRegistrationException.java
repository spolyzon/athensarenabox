package com.athensarenabox.subscription.exceptions;

public class DuplicateRegistrationException extends RuntimeException {

    public static final String DUPLICATE_REGISTRATION_EXCEPTION_FORMAT =
            "{ \"message\" : \"A client with the specified mobile number (%s) is already registered\"}";

    private final String mobile;

    public DuplicateRegistrationException(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getMessage() {
        return String.format(DUPLICATE_REGISTRATION_EXCEPTION_FORMAT, mobile);
    }
}
