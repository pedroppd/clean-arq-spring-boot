package com.web3.wallet.domain.wallet.interfaces.ports;

import com.web3.wallet.domain.wallet.Wallet;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface IWalletRepositoryPort {
    CompletableFuture<Optional<Wallet>> getWalletByUuid(String uuid);
}
