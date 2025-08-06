package com.SalutemBurguer.Backend.repository;

import com.SalutemBurguer.Backend.model.PedidoItemBebidaModel;
import com.SalutemBurguer.Backend.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemBebidaRepository extends JpaRepository<PedidoItemBebidaModel, Long> {
    void deleteAllByPedidoModel(PedidoModel pedido);
}
