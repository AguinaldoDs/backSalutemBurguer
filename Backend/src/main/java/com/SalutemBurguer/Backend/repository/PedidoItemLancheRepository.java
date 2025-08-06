package com.SalutemBurguer.Backend.repository;

import com.SalutemBurguer.Backend.model.PedidoItemLancheModel;
import com.SalutemBurguer.Backend.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemLancheRepository extends JpaRepository<PedidoItemLancheModel, Long> {
    void deleteAllByPedidoModel(PedidoModel pedido);
}