package com.example.qr_wallet_payment.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity //mark this as entity class for db use
@Table(name = "merchants") //specify the table name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id; //unique merchand id

    @Column(nullable = false) //unique = false by default as well
    private String name; // Merchant name

    @Column(nullable = false,unique = true)
    private  String phone;

    private String qrCodePath; //Path to generate the QR code

    private Double balance = 0.0; //Wallet balance default 0
}
