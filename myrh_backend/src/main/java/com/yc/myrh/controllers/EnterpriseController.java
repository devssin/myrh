package com.yc.myrh.controllers;

import com.yc.myrh.dto.Enterprise.EnterpriseRequestDto;
import com.yc.myrh.dto.Enterprise.EnterpriseResponseDto;
import com.yc.myrh.services.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {
    @Autowired
    private IEnterpriseService enterpriseService;
    @PostMapping
    public ResponseEntity<EnterpriseResponseDto> create(EnterpriseRequestDto enterpriseRequestDto) {
        return ResponseEntity.ok(enterpriseService.create(enterpriseRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<EnterpriseResponseDto> >getAll() {
        return ResponseEntity.ok(enterpriseService.getAll());
    }

    @GetMapping("/{id}")
    public EnterpriseResponseDto getById( @PathVariable String id) {
        return enterpriseService.getById(id);
    }

    @PutMapping
    public EnterpriseResponseDto update(EnterpriseRequestDto enterpriseRequestDto) {
        return enterpriseService.update(enterpriseRequestDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete( @PathVariable String id) {
        return enterpriseService.delete(id);
    }

}
