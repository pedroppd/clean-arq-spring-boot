package com.web3.wallet.infra.entities;

import com.web3.wallet.domain.wallet.Wallet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Table(name = "user")
@Entity
@Getter@Setter
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private String name;
}
