package com.example.qr_wallet_payment.controller;

import com.example.qr_wallet_payment.entity.Transaction;
import com.example.qr_wallet_payment.service.TransactionService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Page<Transaction>> getCustomerTransactions(
            @PathVariable String customerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(transactionService.getCustomerTransactions(customerId,page,size));
    }


    @GetMapping("/mechant/{merchantId}")
    public ResponseEntity<Page<Transaction>> getMerchantTransactions(
            @PathVariable String merchantId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(transactionService.getMerchantTransactions(merchantId,page,size));
    }
}
