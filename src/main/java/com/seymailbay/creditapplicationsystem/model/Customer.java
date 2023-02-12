package com.seymailbay.creditapplicationsystem.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerID;

    @Column(name = "turkishRepublicId",nullable =false,unique = true,length = 11, updatable = false)
    private String turkishRepublicID;

    @Column(name= "name",nullable = false, length = 55)
    private String name;

    @Column(name="surname", nullable = false, length = 55)
    private String surname;

    @Column(name="salary",nullable = false)
    private BigDecimal salary;

    @Column(name="phone",nullable = false,length = 10)
    private int phone;

    @Column(name="dateOfBirth",nullable = false)
    private Date dateOfBirth;

    @Column(name="amountofGuarantee")
    private BigDecimal amountOfGuarantee;

    public Customer(long customerID, String turkishRepublicID, String name, String surname, BigDecimal salary, int phone, Date dateOfBirth, BigDecimal amountOfGuarantee) {
        this.customerID = customerID;
        this.turkishRepublicID = turkishRepublicID;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.amountOfGuarantee = amountOfGuarantee;
    }

    public Customer(long customerID, String turkishRepublicID, String name, String surname, BigDecimal salary, int phone, Date dateOfBirth) {
        this.customerID = customerID;
        this.turkishRepublicID = turkishRepublicID;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

}
