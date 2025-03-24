package com.example.qr_wallet_payment.service;

import com.example.qr_wallet_payment.entity.Merchant;
import com.example.qr_wallet_payment.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public Merchant registerMerchant(String name, String phone) {
        if (merchantRepository.findByPhone(phone).isPresent()) {
            throw new RuntimeException("Merchant with this phone already exists.");
        }
        Merchant merchant = new Merchant();
        merchant.setName(name);
        merchant.setPhone(phone);
        merchant.setQrCodePath("qr_codes/" + name.replaceAll(" ", "_") + ".png");
        merchant.setBalance(0.0);

        return merchantRepository.save(merchant);
    }
}
