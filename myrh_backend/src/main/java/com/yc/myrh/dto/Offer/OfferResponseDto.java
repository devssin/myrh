package com.yc.myrh.dto.Offer;

import com.yc.myrh.dto.Candidature.CandidatureRequestDto;
import com.yc.myrh.dto.Enterprise.EnterpriseRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class OfferResponseDto {
    private String id;
    private String title;
    private String description;
    private String profile;
    private String salary;
    private String status;
    private EnterpriseRequestDto enterprise;
    private List<CandidatureRequestDto> candidatures;
}
