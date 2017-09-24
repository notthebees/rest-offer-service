package org.paddy.offer.repository;

import org.paddy.offer.model.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
