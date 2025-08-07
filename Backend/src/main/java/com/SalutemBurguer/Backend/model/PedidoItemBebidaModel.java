package com.SalutemBurguer.Backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "pedido_item_bebida")
public class PedidoItemBebidaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long quantidade_pedido;

    @Column(nullable = false)
    private Long id_bebida;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonBackReference("bebida-pedido")
    private PedidoModel pedidoModel;
}
