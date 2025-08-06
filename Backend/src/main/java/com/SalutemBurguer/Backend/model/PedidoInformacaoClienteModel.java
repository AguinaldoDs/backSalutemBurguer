package com.SalutemBurguer.Backend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "informacoes_cliente_pedido")
public class PedidoInformacaoClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonBackReference("informacoesCliente-pedido")
    private PedidoModel pedidoModel;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String endereco;

    @Column(nullable = true)
    private String telefone;

}
