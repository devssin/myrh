package com.yc.myrh.services;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOfferService {
    OfferResponseDto createOffer(OfferRequestDto offerRequestDto);
    Page<OfferResponseDto> getAllOffers(Pageable pageable);
    Page<OfferResponseDto> getOffersByEnterprise(Pageable pageable, String enterpriseId);

    List<OfferResponseDto> getAllOffers();

    OfferResponseDto getOfferById(String id);
    OfferResponseDto updateOffer(OfferRequestDto offerRequestDto);
    boolean deleteOffer(String id);
}
