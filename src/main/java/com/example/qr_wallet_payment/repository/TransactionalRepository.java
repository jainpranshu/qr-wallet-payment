package com.example.qr_wallet_payment.repository;

import com.example.qr_wallet_payment.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionalRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findByCustomerId(String customerId);
    List<Transaction> findByMerchantId(String merchantId);

    // Fetch transactions for a specific customer (with pagination)
    Page<Transaction> findByCustomerId(String customerId, Pageable pageable);

    // Fetch transactions for a specific merchant (with pagination)
    Page<Transaction> findByMerchantId(String merchantId, Pageable pageable);
}
