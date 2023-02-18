package com.seymailbay.creditapplicationsystem.dto.creditDto;

import com.seymailbay.creditapplicationsystem.model.Credit;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Random;

@Data
@Getter
public class CreditDto implements Serializable {

    private Credit credit;
    private int creditScore;
    private boolean creditApplyingStatus;
    private boolean creditResult;

    private double creditLimit;

    private CreditDto(boolean creditApplyingStatus, boolean creditResult,double creditLimit){
        this.creditApplyingStatus=creditApplyingStatus;
        this.creditResult=creditResult;
        this.creditLimit=creditLimit;
    }

    public CreditDto(boolean creditResult) {
        this.creditResult = creditResult;
    }

    public CreditDto() {
    }

    public static CreditDto ofCreditResult(Credit credit){
        return new CreditDto(credit.isCreditResult());
    }
}
