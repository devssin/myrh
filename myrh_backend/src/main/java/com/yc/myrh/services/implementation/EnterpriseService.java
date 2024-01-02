package com.yc.myrh.services.implementation;

import com.yc.myrh.dto.Enterprise.EnterpriseRequestDto;
import com.yc.myrh.dto.Enterprise.EnterpriseResponseDto;
import com.yc.myrh.dto.Enterprise.VerifyRequestDto;
import com.yc.myrh.entities.Enterprise;
import com.yc.myrh.exceptions.ResourceNotFoundException;
import com.yc.myrh.helpers.EmailSender;
import com.yc.myrh.repositories.EnterpriseRepository;
import com.yc.myrh.services.IEnterpriseService;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EnterpriseService implements IEnterpriseService {
    private EnterpriseRepository enterpriseRepository;
    private ModelMapper modelMapper;
    private EmailSender emailSender;

    @Override
    @Transactional
    public EnterpriseResponseDto create(EnterpriseRequestDto enterpriseRequestDto) {
        Enterprise enterprise = modelMapper.map(enterpriseRequestDto, Enterprise.class);
        enterprise.setCode(UUID.randomUUID().toString());

        enterpriseRepository.save(enterprise);
        emailSender.sendEmail(enterprise.getEmail(), "Verification code", "Your verification code is " + enterprise.getCode());
        saveImage(enterpriseRequestDto.getImage(), enterprise.getId());
        return modelMapper.map(enterprise, EnterpriseResponseDto.class);
    }

    @Override
    public List<EnterpriseResponseDto> getAll() {
        List<Enterprise> enterprises = enterpriseRepository.findAll();
        return enterprises.stream().map(enterprise -> modelMapper.map(enterprise, EnterpriseResponseDto.class)).toList();
    }

    @Override
    public EnterpriseResponseDto getById(String id) {
        Enterprise enterprise = enterpriseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Enterprise not found"));
        return modelMapper.map(enterprise, EnterpriseResponseDto.class);
    }

    @Override
    public EnterpriseResponseDto update(EnterpriseRequestDto enterpriseRequestDto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean verify(VerifyRequestDto verifyRequestDto) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(verifyRequestDto.getId());
        if (enterprise.isEmpty()) throw new ResourceNotFoundException ("Enterprise not found");
        return enterprise.get().getCode().equals(verifyRequestDto.getCode());
    }


    private void saveImage(MultipartFile file, String id) {
        if(file == null) throw new IllegalArgumentException("Image is required");
        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        if(!extension.equals("png")) throw new IllegalArgumentException("Only png files are allowed");
        String uploadDir = "src/main/resources/static/";
        String fileName = id + "." + extension;
        Path path = Path.of(uploadDir);
        if(!Files.exists(path)){
            try {
                Files.createDirectories(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Path filePath = path.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
