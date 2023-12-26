package com.yc.myrh.services.implementation;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import com.yc.myrh.entities.Enterprise;
import com.yc.myrh.entities.Offer;
import com.yc.myrh.enums.Status;
import com.yc.myrh.repositories.EnterpriseRepository;
import com.yc.myrh.repositories.OfferRepository;
import com.yc.myrh.services.IOfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService implements IOfferService {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public OfferResponseDto createOffer(OfferRequestDto offerRequestDto) {
        System.out.println(offerRequestDto.getEnterprise_id());
        Offer offer = modelMapper.map(offerRequestDto, Offer.class);
        Optional<Enterprise> enterprise = enterpriseRepository.findById(offerRequestDto.getEnterprise_id());
        if(!enterprise.isPresent()) throw new IllegalArgumentException("Enterprise not found");
        offer.setEnterprise(enterprise.get());
        offer.setStatus(Status.ONHOLD);
        offer = offerRepository.save(offer);
        return modelMapper.map(offer, OfferResponseDto.class);

    }
}
