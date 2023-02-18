package com.seymailbay.creditapplicationsystem.service.creditService;

import com.seymailbay.creditapplicationsystem.dto.creditDto.CreditDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerViewDto;
import com.seymailbay.creditapplicationsystem.model.Credit;

import java.util.List;

public interface CreditService {
    CreditDto applyCredit(Long id,CreditDto creditDto);
    Credit getCreditResult(Long id, CreditDto creditDto, CustomerViewDto customerViewDto);

    int calculateCreditScore();
}
