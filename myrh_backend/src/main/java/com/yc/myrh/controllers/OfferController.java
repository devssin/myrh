package com.yc.myrh.controllers;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import com.yc.myrh.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private IOfferService offerService;

    @PostMapping
    public ResponseEntity<OfferResponseDto> create(@RequestBody OfferRequestDto offerRequestDto) {
        return ResponseEntity.ok(offerService.createOffer(offerRequestDto));
    }

}
