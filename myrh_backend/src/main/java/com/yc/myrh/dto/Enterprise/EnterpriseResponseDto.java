package com.yc.myrh.dto.Enterprise;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import com.yc.myrh.dto.Offer.OfferResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class EnterpriseResponseDto {
    private String id;
    private String name;
    private String login;
    private String email;
    private String phone;
    private List<OfferRequestDto> offers;
}
