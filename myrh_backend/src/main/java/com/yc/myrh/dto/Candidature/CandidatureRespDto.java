package com.yc.myrh.dto.Candidature;

import com.yc.myrh.dto.Offer.OfferRequestDto;
import lombok.Data;

@Data
public class CandidatureRespDto {
    private String id;
    private String fullname;
    private String email;
    private String phone;
    private String coverLetter;
    private String status;
    private OfferRequestDto offer;

}
