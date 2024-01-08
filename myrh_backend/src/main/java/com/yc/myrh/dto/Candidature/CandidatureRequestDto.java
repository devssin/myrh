package com.yc.myrh.dto.Candidature;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CandidatureRequestDto {
    private String id;
    private String fullname;
    private String email;
    private String phone;
    private String coverLetter;
    private String status;
    private MultipartFile cv;
    private String offerId;
}

