package com.web3.wallet.application;

import com.web3.wallet.domain.currency.Currency;
import com.web3.wallet.domain.currency.interfaces.ports.ICurrencyRepositoryPort;
import com.web3.wallet.domain.wallet.Wallet;
import com.web3.wallet.domain.wallet.interfaces.ports.IWalletRepositoryPort;
import com.web3.wallet.domain.walletcurrency.WalletCurrency;
import com.web3.wallet.domain.walletcurrency.interfaces.ports.IWalletCurrencyRepositoryPort;
import com.web3.wallet.domain.walletcurrency.interfaces.ports.usecases.IBuyCurrencyUseCase;

public class BuyCurrencyUseCase implements IBuyCurrencyUseCase {

    private final IWalletCurrencyRepositoryPort walletCurrencyRepositoryPort;
    private final IWalletRepositoryPort walletRepositoryPort;

    private final ICurrencyRepositoryPort currencyRepositoryPort;

    public BuyCurrencyUseCase(IWalletCurrencyRepositoryPort walletCurrencyPort,
                              IWalletRepositoryPort walletPort,
                              ICurrencyRepositoryPort currencyPort) {
        this.walletCurrencyRepositoryPort = walletCurrencyPort;
        this.walletRepositoryPort = walletPort;
        this.currencyRepositoryPort = currencyPort;
    }

    /*
     * @Description Associate wallet to currency
     * @Exception When wallet or currency is null then is throwing a exception
     * @return Wallet and Currency saved
     */
    public WalletCurrency execute(Wallet wallet, Currency currency) {
        try {
            var optionalWallet = this.walletRepositoryPort.getWalletByUuid(wallet.getUuid());
            if (optionalWallet.isEmpty()) {
                throw new RuntimeException("Wallet not exists !");
            }

            var optionalCurrency = this.currencyRepositoryPort.getCurrencyByUuid(currency.getUuid());
            if (optionalCurrency.isEmpty()) {
                throw new RuntimeException("Currency not exists !");
            }

            WalletCurrency walletCurrency = new WalletCurrency().setCurrency(currency).setWallet(wallet);
            return this.walletCurrencyRepositoryPort.save(walletCurrency);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
