package com.yc.myrh.dto.Enterprise;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EnterpriseRequestDto {
    private String id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name must be a maximum of 100 characters")
    private String name;

    @NotBlank(message = "Login is mandatory")
    @Size(max = 50, message = "Login must be a maximum of 50 characters")
    private String login;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be between 8 and 50 characters")

    private String password;


    @NotNull(message = "Phone is mandatory")
    @NotBlank(message = "Phone is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone should be valid")
    private String phone;

    private MultipartFile image;
}
