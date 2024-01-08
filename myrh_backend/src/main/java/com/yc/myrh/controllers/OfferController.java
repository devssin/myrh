package com.yc.myrh.controllers;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import com.yc.myrh.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offers")
@CrossOrigin("http://localhost:4200")
public class OfferController {
    @Autowired
    private IOfferService offerService;

    @PostMapping
    public ResponseEntity<OfferResponseDto> create(@RequestBody OfferRequestDto offerRequestDto) {
        return ResponseEntity.ok(offerService.createOffer(offerRequestDto));
    }

    @GetMapping
    public ResponseEntity<Page<OfferResponseDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(offerService.getAllOffers(PageRequest.of(page, size)));
    }
    @GetMapping("/{enterpriseId}")
    public ResponseEntity<Page<OfferResponseDto>> getByEnterprise(@PathVariable String enterpriseId,
                                                                  @RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "10") int size){
        return  ResponseEntity.ok(offerService.getOffersByEnterprise(PageRequest.of(page, size), enterpriseId));


    }



}
