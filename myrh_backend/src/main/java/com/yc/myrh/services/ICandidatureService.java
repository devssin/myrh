package com.yc.myrh.services;

import com.yc.myrh.dto.Candidature.CandidatureRequestDto;
import com.yc.myrh.dto.Candidature.CandidatureRespDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICandidatureService {
    CandidatureRespDto create(CandidatureRequestDto candidatureRequestDto);
    List<CandidatureRespDto> getAllCandidaturesByEnterpriseId(String enterpriseId);
}
