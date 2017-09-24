package org.paddy.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
}
