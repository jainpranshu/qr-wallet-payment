package com.example.qr_wallet_payment.controller;

import com.example.qr_wallet_payment.entity.Merchant;
import com.example.qr_wallet_payment.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/register")
    public ResponseEntity<Merchant> registerMerchant(@RequestParam String name, @RequestParam String phone) {
        Merchant merchant = merchantService.registerMerchant(name, phone);
        return ResponseEntity.ok(merchant);
    }
}
