package org.paddy.offer.controller;

import org.paddy.offer.repository.OfferRepository;
import org.paddy.offer.model.Offer;
import org.paddy.offer.model.OfferNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    @RequestMapping(method = GET)
    public @ResponseBody Iterable<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @RequestMapping(method = GET, value = "/{id}")
    public @ResponseBody Offer getOffer(@PathVariable("id") long id) {
        Offer offer = offerRepository.findOne(id);
        if (offer == null) {
            throw new OfferNotFoundException(id);
        } else {
            return offer;
        }
    }

    @RequestMapping(method = POST)
    public @ResponseBody ResponseEntity add(@Valid @RequestBody Offer offer) {
        Offer result = offerRepository.save(offer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/id")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public @ResponseBody Offer deleteOffer(@PathVariable("id") long id) {
        Offer offer = offerRepository.findOne(id);
        if (offer == null) {
            throw new OfferNotFoundException(id);
        } else {
            offerRepository.delete(id);
            return offer;
        }
    }
}
