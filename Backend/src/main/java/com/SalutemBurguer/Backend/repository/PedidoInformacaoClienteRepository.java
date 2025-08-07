package com.SalutemBurguer.Backend.repository;

import com.SalutemBurguer.Backend.model.PedidoInformacaoClienteModel;
import com.SalutemBurguer.Backend.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoInformacaoClienteRepository extends JpaRepository<PedidoInformacaoClienteModel, Long> {
}
