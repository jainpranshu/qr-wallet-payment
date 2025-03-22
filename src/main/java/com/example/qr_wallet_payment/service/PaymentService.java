package com.example.qr_wallet_payment.service;

import com.example.qr_wallet_payment.entity.Customer;
import com.example.qr_wallet_payment.entity.Merchant;
import com.example.qr_wallet_payment.entity.Transaction;
import com.example.qr_wallet_payment.repository.CustomerRepository;
import com.example.qr_wallet_payment.repository.MerchantRepository;
import com.example.qr_wallet_payment.repository.TransactionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final CustomerRepository customerRepository;
    private final MerchantRepository merchantRepository;
    private final TransactionalRepository transactionalRepository;

    @Transactional //to maintain atomicity // it prevents partial update like money deducted but didn't credit to merchant, So if it fails it revert back everything
    public String processQRPayment(String customerId,String merchantId,Double amount){
        //fetch customer & merchants from the db
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new RuntimeException("Customer not found"));

        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(()-> new RuntimeException("Merchant not found"));

        //check enough balance is there or not
        if(customer.getWalletBalance() < amount){
            throw new RuntimeException("Insufficient fund");
        }

        //deduct from customer wallet
        customer.setWalletBalance(customer.getWalletBalance()-amount);

        //add to merchant wallet
        merchant.setBalance(merchant.getBalance()+amount);

        //create and save transaction
        Transaction transaction = new Transaction(customer,merchant,amount);
        transactionalRepository.save(transaction);

        return "Payment Successful! Transaction Id: " + transaction.getId();
    }

}
