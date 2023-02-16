package com.seymailbay.creditapplicationsystem.dto.customerDto;

import com.seymailbay.creditapplicationsystem.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class CustomerViewDto implements Serializable {

    private Long customerId;
    private String turkishRepublicId;
    private String name;
    private String surname;
    private double salary;

    private String phone;
    private String dateOfBirth;
    private double amountOfGuarantee;
    private int creditScore;

    public CustomerViewDto(Long customerID, String turkishRepublicId, String name, String surname, double salary,String phone, String dateOfBirth, double amountOfGuarantee, int creditScore) {
        this.customerId=customerID;
        this.turkishRepublicId = turkishRepublicId;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone=phone;
        this.dateOfBirth = dateOfBirth;
        this.amountOfGuarantee = amountOfGuarantee;
        this.creditScore = creditScore;
    }
    public static CustomerViewDto of(Customer customer) {
        return new CustomerViewDto(customer.getCustomerID(),
                customer.getTurkishRepublicID(),
                customer.getName(),
                customer.getSurname(),
                customer.getSalary(),
                customer.getPhone(),
                customer.getDateOfBirth(),
                customer.getAmountOfGuarantee(),
                customer.getCreditScore());
    }

}
