package com.seymailbay.creditapplicationsystem.dto.customerDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CustomerUpdateDto {

    private Long customerId;

    private String turkishRepublicId;

    private String name;

    private String surname;

    private double salary;

    private String phone;

    private String dateOfBirth;

    private double amountOfGuarantee;
}
