package com.seymailbay.creditapplicationsystem.dto.customer;

import com.seymailbay.creditapplicationsystem.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerViewDto implements Serializable {

    private long customerId;

    private String turkishRepublicId;

    private String name;

    private String surname;

    private BigDecimal salary;

    private Date dateOfBirth;

    private BigDecimal amountOfGuarantee;

    public CustomerViewDto(String turkishRepublicID, Date dateOfBirth) {
    }

    public static CustomerViewDto of(Customer customer) {
        return new CustomerViewDto(customer.getTurkishRepublicID(), customer.getDateOfBirth());
    }

}
