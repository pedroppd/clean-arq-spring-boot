package com.web3.wallet.infra.entities;

import com.web3.wallet.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "wallet")
@Entity
@Getter@Setter
public class WalletEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public String getUuid() {
        return uuid;
    }
}
