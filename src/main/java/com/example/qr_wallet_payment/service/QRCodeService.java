package com.example.qr_wallet_payment.service;

import com.example.qr_wallet_payment.entity.Merchant;
import com.example.qr_wallet_payment.repository.MerchantRepository;
import com.example.qr_wallet_payment.utils.QRCodeDecoder;
import com.google.zxing.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QRCodeService {
    private final MerchantRepository merchantRepository;

    public Merchant scanQRCode(MultipartFile file) throws IOException, NotFoundException {
        //convert uploaded file to local file
        Path tempFile = Paths.get(System.getProperty("java.io.tmdir",file.getOriginalFilename()));
        file.transferTo(tempFile.toFile());

        //decode QR image
        String qrText = QRCodeDecoder.decodeQRCode(tempFile.toFile());

        //extract merchanID from QR code content
        if(qrText.startsWith("merchantId:")){
            String[] parts = qrText.split(":");
            if(parts.length<2){
                throw new RuntimeException("Invalid QR Code Format");
            }
            String merchantId = parts[1];

            //find merchant by ID
            Optional<Merchant> merchant  = merchantRepository.findById(merchantId);
            return merchant.orElseThrow(()-> new RuntimeException("Merchant Not FOund"));
        }else{
            throw new RuntimeException("Invalid QR Code COntent");
        }
    }
}
