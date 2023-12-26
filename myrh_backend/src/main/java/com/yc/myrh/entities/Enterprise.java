package com.yc.myrh.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String login;
    private String email;
    private String password;
    private String phone;

    @OneToMany(mappedBy = "enterprise" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer> offers;

}
