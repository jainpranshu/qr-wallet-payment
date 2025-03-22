package com.example.qr_wallet_payment.service;

import com.example.qr_wallet_payment.entity.Customer;
import com.example.qr_wallet_payment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer  registerCustomer(String name, String phone){
        if(customerRepository.findByPhone(phone).isPresent()){
            throw new RuntimeException("Customer with phone is already exist");
        }

        Customer customer = new Customer();

        customer.setName(name);
        customer.setPhone(phone);
        customer.setWalletBalance(1000.00);

        return customerRepository.save(customer);
    }
}
