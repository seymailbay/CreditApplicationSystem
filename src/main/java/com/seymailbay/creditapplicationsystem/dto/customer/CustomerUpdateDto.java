package com.seymailbay.creditapplicationsystem.dto.customer;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerUpdateDto {

    private long customerId;

    private String turkishRepublicId;

    private String name;

    private String surname;

    private BigDecimal salary;

    private Date dateOfBirth;

    private BigDecimal amountOfGuarantee;
}
