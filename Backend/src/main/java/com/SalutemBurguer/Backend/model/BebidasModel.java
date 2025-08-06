package com.SalutemBurguer.Backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="bebidas")
@Getter
@Setter
public class BebidasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco_uni;

    @Column(nullable = false)
    private boolean zero_acucar;

    private Boolean ativo = true;

}
