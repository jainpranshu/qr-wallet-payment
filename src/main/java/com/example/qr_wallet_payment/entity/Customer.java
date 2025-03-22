package com.example.qr_wallet_payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(nullable = false , unique = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    private Double walletBalance = 1000.00; //default balance will be 1000

}
