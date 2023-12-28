package com.yc.myrh.services;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOfferService {
    OfferResponseDto createOffer(OfferRequestDto offerRequestDto);
    List<OfferResponseDto> getAllOffers();
    OfferResponseDto getOfferById(String id);
    OfferResponseDto updateOffer(OfferRequestDto offerRequestDto);
    boolean deleteOffer(String id);
}
