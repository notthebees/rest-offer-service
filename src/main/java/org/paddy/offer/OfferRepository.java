package org.paddy.offer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
