package com.web3.wallet.infra.repositories.wallet;

import com.web3.wallet.domain.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStringWalletRepository extends JpaRepository<Wallet, String> {
    Wallet getWalletByUuid(String uuid);
}
