package com.web3.wallet.domain.walletcurrency.interfaces.ports;

import com.web3.wallet.domain.walletcurrency.WalletCurrency;

public interface IWalletCurrencyRepositoryPort {

    WalletCurrency save(WalletCurrency walletCurrency);
}
