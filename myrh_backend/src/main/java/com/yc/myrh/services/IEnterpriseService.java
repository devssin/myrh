package com.yc.myrh.services;

import com.yc.myrh.dto.Enterprise.EnterpriseRequestDto;
import com.yc.myrh.dto.Enterprise.EnterpriseResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEnterpriseService {
    EnterpriseResponseDto create(EnterpriseRequestDto enterpriseRequestDto);
    List<EnterpriseResponseDto> getAll();
    EnterpriseResponseDto getById(String id);
    EnterpriseResponseDto update(EnterpriseRequestDto enterpriseRequestDto);
    boolean delete(String id);
}
