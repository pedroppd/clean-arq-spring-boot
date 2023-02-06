package com.web3.wallet.domain.walletcurrency.interfaces.ports.usecases;

import com.web3.wallet.domain.currency.Currency;
import com.web3.wallet.domain.wallet.Wallet;
import com.web3.wallet.domain.walletcurrency.WalletCurrency;

public interface IBuyCurrencyUseCase {

    WalletCurrency execute(Wallet wallet, Currency currency) throws Exception;
}
