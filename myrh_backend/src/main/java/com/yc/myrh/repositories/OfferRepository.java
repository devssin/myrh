package com.yc.myrh.repositories;

import com.yc.myrh.entities.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
    Page<Offer> findByEnterpriseId(String enterpriseId, Pageable pageable);


}
