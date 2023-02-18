package com.seymailbay.creditapplicationsystem.api.creditApi;


import com.seymailbay.creditapplicationsystem.dto.creditDto.CreditDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerViewDto;
import com.seymailbay.creditapplicationsystem.model.Credit;
import com.seymailbay.creditapplicationsystem.service.creditService.CreditService;
import com.seymailbay.creditapplicationsystem.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CreditApi {

    private final CreditService creditService;

    @PostMapping("v1/credit")
    public ResponseEntity<?> applyCredit(@RequestParam Long id, CreditDto creditDto){
        creditService.applyCredit(id,creditDto);
        return ResponseEntity.ok(new GenericResponse("Application successfully submitted"));
    }

    @GetMapping("v1/credit")
    public ResponseEntity<Credit> getCreditResult(@RequestParam Long id, CreditDto creditDto, CustomerViewDto customerViewDto){
        final Credit credit=creditService.getCreditResult(id,creditDto,customerViewDto);
        return ResponseEntity.ok(credit);
    }



}


