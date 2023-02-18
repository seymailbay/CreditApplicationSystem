package com.seymailbay.creditapplicationsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="credit")
@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "creditScore",nullable = true)
    private int creditScore;

    @Column(name="creditApplyingStatus")
    private boolean creditApplyingStatus=false;

    @Column(name="creditResult",nullable = true)
    private boolean creditResult;

    @Column(name="creditLimit",nullable = true)
    private double creditLimit;

    /*@OneToOne
    @MapsId
    private Customer customer;*/

    public Credit(int creditScore) {
        this.creditScore = creditScore;
    }
    public Credit(boolean creditApplyingStatus) {
        this.creditApplyingStatus = creditApplyingStatus;
    }

}
