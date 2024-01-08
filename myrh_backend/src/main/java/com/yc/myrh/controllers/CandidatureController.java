package com.yc.myrh.controllers;

import com.yc.myrh.dto.Candidature.CandidatureRequestDto;
import com.yc.myrh.dto.Candidature.CandidatureRespDto;
import com.yc.myrh.services.ICandidatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatures")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class CandidatureController {
    private ICandidatureService candidatureService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CandidatureRespDto> create(@ModelAttribute CandidatureRequestDto candidatureRequestDto) {
        return ResponseEntity.ok(candidatureService.create(candidatureRequestDto));
    }

    @GetMapping("/{enterpriseId}")
    public ResponseEntity<List<CandidatureRespDto>> getAllCandidaturesByEnterpriseId(@PathVariable String enterpriseId) {

        return ResponseEntity.ok(candidatureService.getAllCandidaturesByEnterpriseId(enterpriseId));
    }

}
