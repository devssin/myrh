package com.yc.myrh.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fullname;
    private String email;
    private String phone;
    private String coverLetter;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;




}
