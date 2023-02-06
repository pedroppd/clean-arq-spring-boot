package com.web3.wallet.application;

import com.web3.wallet.domain.currency.Currency;
import com.web3.wallet.domain.currency.interfaces.ports.ICurrencyRepositoryPort;
import com.web3.wallet.domain.wallet.Wallet;
import com.web3.wallet.domain.wallet.interfaces.ports.IWalletRepositoryPort;
import com.web3.wallet.domain.walletcurrency.WalletCurrency;
import com.web3.wallet.domain.walletcurrency.interfaces.ports.IWalletCurrencyRepositoryPort;
import com.web3.wallet.domain.walletcurrency.interfaces.ports.usecases.IBuyCurrencyUseCase;

import java.util.Optional;

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
    public WalletCurrency execute(Wallet wallet, Currency currency) throws Exception {
        try {
            Optional<Wallet> optionalWallet = this.walletRepositoryPort.getWalletByUuid(wallet.getUuid()).join();
            if (optionalWallet.isEmpty()) {
                //add exception handler
                throw new Exception("Currency is empty.");
            }

            Optional<Currency> optionalCurrency = this.currencyRepositoryPort.getCurrencyByUuid(currency.getUuid()).join();
            if (optionalCurrency.isEmpty()) {
                //add exception handler
                throw new Exception("Currency is empty.");
            }
            WalletCurrency walletCurrency = new WalletCurrency().setCurrency(currency).setWallet(wallet);
            return this.walletCurrencyRepositoryPort.save(walletCurrency);
        } catch (Exception ex) {
            System.out.println("Error to try save Wallet and Currency: " + ex.getMessage());
            throw ex;
        }
    }
}
