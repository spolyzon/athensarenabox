package com.athensarenabox.subscription.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AthensArenaBoxExceptionHandler {

    @ExceptionHandler(DuplicateRegistrationException.class)
    public ResponseEntity<?> duplicateRegistrationDetected(DuplicateRegistrationException dre) {
        return ResponseEntity.badRequest().body(dre.getMessage());
    }

    @ExceptionHandler(UnknownClientMobileReceived.class)
    public ResponseEntity<?> unknownMobileNumberReceived(UnknownClientMobileReceived ucmr) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ucmr.getMessage());
    }
}
