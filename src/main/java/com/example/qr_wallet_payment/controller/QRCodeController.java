package com.example.qr_wallet_payment.controller;

import com.example.qr_wallet_payment.entity.Merchant;
import com.example.qr_wallet_payment.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/qr")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeService qrCodeService;


    @PostMapping("/scan")
    public ResponseEntity<?> scanQRCode(@RequestParam("file")MultipartFile file){
        try{
            Merchant merchant = qrCodeService.scanQRCode(file);
            return ResponseEntity.ok(merchant);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to process the QR Code" + e.getMessage());
        }
    }

}
