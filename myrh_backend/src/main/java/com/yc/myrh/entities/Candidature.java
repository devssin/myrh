package com.yc.myrh.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Candidature {
    @EmbeddedId
    private CandidatureId id;
    private String coverLetter;


}
