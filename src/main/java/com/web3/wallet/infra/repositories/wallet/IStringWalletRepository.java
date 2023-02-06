package com.web3.wallet.infra.repositories.wallet;

import com.web3.wallet.domain.wallet.Wallet;
import com.web3.wallet.infra.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStringWalletRepository extends JpaRepository<WalletEntity, String> {
    Wallet getWalletByUuid(String uuid);
}
