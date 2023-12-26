package com.yc.myrh.dto.Enterprise;

import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EnterpriseRequestDto {
    private String id;
    private String name;
    private String login;
    private String email;
    private String password;
    private String phone;
    private MultipartFile image;
}
