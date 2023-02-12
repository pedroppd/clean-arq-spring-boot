package com.web3.wallet.domain.currency.interfaces.ports;

import com.web3.wallet.domain.currency.Currency;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ICurrencyRepositoryPort {

    Optional<Currency> getCurrencyByUuid(String uuid);
}
