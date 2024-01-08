package com.yc.myrh.repositories;

import com.yc.myrh.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, String> {
    List<Candidature> findAllByOffer_Enterprise_Id(String enterpriseId);
}
