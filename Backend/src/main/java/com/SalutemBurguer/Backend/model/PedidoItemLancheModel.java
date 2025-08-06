package com.SalutemBurguer.Backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pedido_item_lanche")
public class PedidoItemLancheModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long quantidade_pedido;

    @Column(nullable = false)
    private Long id_lanche;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonBackReference("lanche-pedido")
    private PedidoModel pedidoModel;
}
