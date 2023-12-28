package com.yc.myrh.services.implementation;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import com.yc.myrh.entities.Enterprise;
import com.yc.myrh.entities.Offer;
import com.yc.myrh.enums.Status;
import com.yc.myrh.exceptions.ResourceNotFoundException;
import com.yc.myrh.repositories.EnterpriseRepository;
import com.yc.myrh.repositories.OfferRepository;
import com.yc.myrh.services.IOfferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class OfferService implements IOfferService {

    private OfferRepository offerRepository;
    private EnterpriseRepository enterpriseRepository;
    ModelMapper modelMapper;
    @Override
    public OfferResponseDto createOffer(OfferRequestDto offerRequestDto) {
        System.out.println(offerRequestDto.getEnterprise_id());
        Offer offer = modelMapper.map(offerRequestDto, Offer.class);
        Enterprise enterprise = enterpriseRepository.findById(offerRequestDto.getEnterprise_id()).orElse(null);
        if(enterprise == null) throw new ResourceNotFoundException("Enterprise not found");
        offer.setEnterprise(enterprise);
        offer.setStatus(Status.ONHOLD);
        offer = offerRepository.save(offer);
        return modelMapper.map(offer, OfferResponseDto.class);
    }

    @Override
    public List<OfferResponseDto> getAllOffers() {
        return null;
    }

    @Override
    public OfferResponseDto getOfferById(String id) {
        return null;
    }

    @Override
    public OfferResponseDto updateOffer(OfferRequestDto offerRequestDto) {
        return null;
    }

    @Override
    public boolean deleteOffer(String id) {
        return false;
    }


}
