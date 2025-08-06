package com.SalutemBurguer.Backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "lanche_ingredientes")
public class LancheItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_lanche")
    @JsonBackReference
    private LancheModel lanche;

    @Column(nullable = false)
    private Long id_ingrediente;

    @Column(nullable = false)
    private String descricao_ingrediente;

    @Column(nullable = false)
    private BigDecimal preco_ingrediente;

    @Column(nullable = false)
    private Long quantidade_padrao;

    @Column(nullable = true)
    private Boolean ativo;



}
