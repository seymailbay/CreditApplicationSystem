package com.seymailbay.creditapplicationsystem.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @Column(name = "turkishRepublicId",nullable =false,unique = true,length = 11, updatable = false)
    private String turkishRepublicID;

    @Column(name= "name",nullable = false, length = 55)
    private String name;

    @Column(name="surname", nullable = false, length = 55)
    private String surname;

    @Column(name="salary",nullable = false)
    private double salary;

    @Column(name="phone",nullable = false,length = 10)
    private String phone;

    @Column(name="dateOfBirth",nullable = false)
    private String dateOfBirth;

    @Column(name="amountofGuarantee",nullable = true)
    private double amountOfGuarantee;

    @Column(name="creditScore",nullable = true)
    private double creditScore;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Credit credit;

    public Customer(String turkishRepublicID, String name, String surname, double salary, String phone, String dateOfBirth, double amountOfGuarantee, double creditScore) {
        this.turkishRepublicID = turkishRepublicID;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.amountOfGuarantee = amountOfGuarantee;
        this.creditScore = creditScore;
    }

    public Customer(String turkishRepublicID, String name, String surname, double salary, String phone, String dateOfBirth) {
        this.turkishRepublicID = turkishRepublicID;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }




    //     (new Customer(customerCreateDto.getCustomerID(),customerCreateDto.getTurkishRepublicId(),
    //                        customerCreateDto.getName(),
    //                        customerCreateDto.getSurname(),
    //                        customerCreateDto.getSalary(),
    //                        customerCreateDto.getPhone(),
    //                        customerCreateDto.getDateOfBirth(),
    //                        customerCreateDto.getAmountOfGuarantee(),
    //                        customerCreateDto.getCreditScore()));

    public Customer(Long customerID,
                    String turkishRepublicID,
                    String name, String surname,
                    double salary, String phone,
                    String dateOfBirth, double amountOfGuarantee,
                    int creditScore,Credit credit) {
        this.customerID = customerID;
        this.turkishRepublicID = turkishRepublicID;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.amountOfGuarantee = amountOfGuarantee;
        this.creditScore = creditScore;
        this.credit=credit;
    }
}
