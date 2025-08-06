package com.SalutemBurguer.Backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pedidos")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private LocalDateTime dataRegistro;

    @OneToMany(mappedBy = "pedidoModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("informacoesCliente-pedido")
        private List<PedidoInformacaoClienteModel> informacoesCliente;

    @OneToMany(mappedBy = "pedidoModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("lanche-pedido")
    private List<PedidoItemLancheModel> itemLancheModel;

    @OneToMany(mappedBy = "pedidoModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("bebida-pedido")
    private List<PedidoItemBebidaModel> itemBebidaModel;

}