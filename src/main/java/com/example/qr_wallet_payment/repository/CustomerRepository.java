package com.example.qr_wallet_payment.repository;

import com.example.qr_wallet_payment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, String> {
    Optional<Customer> findByPhone(String Phone);
}
