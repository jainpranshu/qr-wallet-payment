package com.example.qr_wallet_payment.service;

import com.example.qr_wallet_payment.entity.Transaction;
import com.example.qr_wallet_payment.repository.TransactionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class TransactionService {

    private final TransactionalRepository transactionalRepository;

    public Page<Transaction> getCustomerTransactions(String customerId, int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return transactionalRepository.findByCustomerId(customerId,pageable);
    }

    public Page<Transaction> getMerchantTransactions(String merchantId,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return transactionalRepository.findByMerchantId(merchantId,pageable);
    }
}
