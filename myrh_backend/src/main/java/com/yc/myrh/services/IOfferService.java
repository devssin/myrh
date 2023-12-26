package com.yc.myrh.services;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface IOfferService {
    OfferResponseDto createOffer(OfferRequestDto offerRequestDto);
}
