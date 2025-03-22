package com.example.qr_wallet_payment.controller;

import com.example.qr_wallet_payment.entity.Customer;
import com.example.qr_wallet_payment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class customerController {

    private final CustomerService customerService;

    public ResponseEntity<Customer> registerCustomer(@RequestParam String name, @RequestParam String phone){
        try{
            return ResponseEntity.ok(customerService.registerCustomer(name, phone));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
