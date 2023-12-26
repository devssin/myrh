package com.yc.myrh.repositories;

import com.yc.myrh.entities.Candidature;
import com.yc.myrh.entities.CandidatureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, CandidatureId> {
}
