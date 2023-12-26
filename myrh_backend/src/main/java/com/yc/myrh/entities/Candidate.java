package com.yc.myrh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fullname;
    private String email;
    private String phone;

    @ManyToMany(mappedBy = "candidates")
    private List<Offer> offers;


}
