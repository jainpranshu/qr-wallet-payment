package com.example.qr_wallet_payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class Transaction {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "merchant_id",nullable = false)
    private Merchant merchant;

    private Double amount;

    private LocalDateTime timeStamp;

    public Transaction(Customer customer, Merchant merchant, Double amount){
        this.id = generateTransactionId();
        this.customer = customer;
        this.merchant = merchant;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    private String generateTransactionId(){
        return "TXN-"+System.currentTimeMillis();
    }
}
