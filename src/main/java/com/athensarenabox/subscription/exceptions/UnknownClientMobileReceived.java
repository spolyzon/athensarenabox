package com.athensarenabox.subscription.exceptions;

public class UnknownClientMobileReceived extends RuntimeException {
    private static final String EXCEPTION_MESSAGE_FORMAT =
            "{ \"message\" : \"The received mobile number (%s) does not correspond to a registered customer\"}";

    private final String mobile;

    public UnknownClientMobileReceived(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_MESSAGE_FORMAT, mobile);
    }
}
