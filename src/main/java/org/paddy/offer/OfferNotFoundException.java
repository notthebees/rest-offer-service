package org.paddy.offer;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
class OfferNotFoundException extends RuntimeException {

    OfferNotFoundException(Long id) {
        super("Could not find offer " + id + ".");
    }
}
