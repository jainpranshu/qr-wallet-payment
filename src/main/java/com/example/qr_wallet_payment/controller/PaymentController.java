package com.example.qr_wallet_payment.controller;

import com.example.qr_wallet_payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    public ResponseEntity<String> makeQRPayment(@RequestParam String customerId,
                                              @RequestParam String merchantId,
                                              @RequestParam Double amount){
        try{
            String response = paymentService.processQRPayment(customerId,merchantId,amount);
            return  ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Payment Failed: "+ e.getMessage());
        }
    }
}
