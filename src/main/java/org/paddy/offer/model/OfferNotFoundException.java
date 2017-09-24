package org.paddy.offer.model;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class OfferNotFoundException extends RuntimeException {

    public OfferNotFoundException(Long id) {
        super("Could not find offer " + id + ".");
    }
}
