package com.yc.myrh.services.implementation;

import com.yc.myrh.dto.Candidature.CandidatureRequestDto;
import com.yc.myrh.dto.Candidature.CandidatureRespDto;
import com.yc.myrh.entities.Candidature;
import com.yc.myrh.entities.Offer;
import com.yc.myrh.exceptions.ResourceNotFoundException;
import com.yc.myrh.helpers.EmailSender;
import com.yc.myrh.repositories.CandidatureRepository;
import com.yc.myrh.repositories.OfferRepository;
import com.yc.myrh.services.ICandidatureService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor

public class CandidatureService implements ICandidatureService {
    OfferRepository offerRepository;
    ModelMapper modelMapper;
    CandidatureRepository candidatureRepository;
    EmailSender emailSender;


    @Override
    public CandidatureRespDto create(CandidatureRequestDto candidatureRequestDto) {
        System.out.println(candidatureRequestDto.getFullname());
        Offer offer = offerRepository.findById(candidatureRequestDto.getOfferId()).orElse(null);
        if(offer == null) throw new ResourceNotFoundException("Offer not found");
        Candidature candidature = modelMapper.map(candidatureRequestDto, Candidature.class);
        candidature.setOffer(offer);
        candidatureRepository.save(candidature);
        saveCv(candidatureRequestDto.getCv(), candidature.getId());
        emailSender.sendEmail(offer.getEnterprise().getEmail(), "New candidature", "You have a new candidature");
        return modelMapper.map(candidature, CandidatureRespDto.class);
    }

    @Override
    public List<CandidatureRespDto> getAllCandidaturesByEnterpriseId(String enterpriseId) {
        List<Candidature> candidatures = candidatureRepository.findAllByOffer_Enterprise_Id(enterpriseId);
        return candidatures.stream().map(candidature -> modelMapper.map(candidature, CandidatureRespDto.class)).toList();
    }

    public void saveCv(MultipartFile file, String id){
        if(file == null) throw new IllegalArgumentException("Cv is required");
        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        if(!extension.equals("pdf")) throw new IllegalArgumentException("Only pdf files are allowed");

        String fileName = id + "." + extension;
        String uploadDir = "src/main/resources/cv/";
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
