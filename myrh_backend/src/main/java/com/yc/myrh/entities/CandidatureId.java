package com.yc.myrh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class CandidatureId implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "offer_id",  insertable = false, updatable = false)
    private Offer offer;

    @ManyToOne()
    @JoinColumn(name = "candidate_id",  insertable = false, updatable = false)
    private Candidate candidate;


}
