package com.SalutemBurguer.Backend.controller;

import com.SalutemBurguer.Backend.model.PedidoModel;
import com.SalutemBurguer.Backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/pedidos/")
@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/findAllPedidos")
    public List<PedidoModel> findAllPedidos() {
        return pedidoRepository.findAll();
    }


    @PostMapping("/savePedido")
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedido) {
        PedidoModel pedidoSalvo = pedidoRepository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }
}
