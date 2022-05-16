package com.athensarenabox.subscription.exceptions;

public class UnknownClientMobileReceived extends RuntimeException {
    private static final String MESSAGE_FORMAT =
            "The received mobile number (%s) does not correspond to an existing customer";

    private final String mobile;

    public UnknownClientMobileReceived(String mobile) {
        super();
        this.mobile = mobile;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE_FORMAT, mobile);
    }
}
