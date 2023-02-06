package com.web3.wallet.domain.walletcurrency;

import com.web3.wallet.domain.currency.Currency;
import com.web3.wallet.domain.wallet.Wallet;

import java.io.Serializable;
import java.util.UUID;

public class WalletCurrency implements Serializable {

    private String uuid;

    private Wallet wallet;

    private Currency currency;

    public WalletCurrency() {
        this.uuid = UUID.randomUUID().toString();
    }

    public WalletCurrency setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public WalletCurrency setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
}
