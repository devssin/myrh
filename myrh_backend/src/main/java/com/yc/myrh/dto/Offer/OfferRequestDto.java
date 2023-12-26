package com.yc.myrh.dto.Offer;

import lombok.Data;

@Data
public class OfferRequestDto {
    private String id;
    private String title;
    private String description;
    private String profile;
    private String salary;
    private String enterprise_id;
}
