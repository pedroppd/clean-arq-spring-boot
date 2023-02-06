package com.web3.wallet.infra.entities;

import com.web3.wallet.domain.currency.Currency;
import com.web3.wallet.domain.wallet.Wallet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Table(name = "wallet_currency")
@Entity
@Getter
@Setter
public class WalletCurrencyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    public WalletCurrencyEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

    public WalletCurrencyEntity setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public WalletCurrencyEntity setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
}
