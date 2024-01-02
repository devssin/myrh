package com.yc.myrh.controllers;

import com.yc.myrh.dto.Enterprise.EnterpriseRequestDto;
import com.yc.myrh.dto.Enterprise.EnterpriseResponseDto;
import com.yc.myrh.dto.Enterprise.VerifyRequestDto;
import com.yc.myrh.services.IEnterpriseService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/enterprises")
@Validated
@CrossOrigin("http://localhost:4200")
public class EnterpriseController {
    private IEnterpriseService enterpriseService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EnterpriseResponseDto> create(@Valid @ModelAttribute EnterpriseRequestDto enterpriseRequestDto) {
        return ResponseEntity.ok(enterpriseService.create(enterpriseRequestDto));
    }

    @PostMapping("/verify")
    public boolean verify(@RequestBody VerifyRequestDto verify){
        return enterpriseService.verify(verify);
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
