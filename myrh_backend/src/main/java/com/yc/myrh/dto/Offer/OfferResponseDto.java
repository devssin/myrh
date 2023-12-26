package com.yc.myrh.dto.Offer;

import com.yc.myrh.dto.Enterprise.EnterpriseResponseDto;
import lombok.Data;

@Data
public class OfferResponseDto {
    private String title;
    private String description;
    private String profile;
    private String salary;
    private String status;
    private EnterpriseResponseDto enterprise;
}
