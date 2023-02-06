package com.web3.wallet.domain.wallet;

import com.web3.wallet.domain.User;

import java.io.Serializable;

public class Wallet implements Serializable {

    private String uuid;
    private String name;
    private User user;

    public String getUuid() {
        return uuid;
    }
}
