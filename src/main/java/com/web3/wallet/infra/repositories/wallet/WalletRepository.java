package com.web3.wallet.infra.repositories.wallet;

import com.web3.wallet.domain.wallet.Wallet;
import com.web3.wallet.domain.wallet.interfaces.ports.IWalletRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class WalletRepository implements IWalletRepositoryPort {

    private final IStringWalletRepository walletRepository;

    public WalletRepository(IStringWalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Optional<Wallet> getWalletByUuid(String uuid) {
        return Optional.ofNullable(this.walletRepository.getWalletByUuid(uuid));
    }
}
