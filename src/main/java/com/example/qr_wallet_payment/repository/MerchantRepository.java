package com.example.qr_wallet_payment.repository;

import com.example.qr_wallet_payment.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {
Optional<Merchant> findByPhone(String phone);

}
