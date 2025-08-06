package com.SalutemBurguer.Backend.controller;

import com.SalutemBurguer.Backend.model.BebidasModel;
import com.SalutemBurguer.Backend.repository.BebidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bebidas")
public class BebidasController {


    @Autowired
    private BebidasRepository bebidasRepository;
    
    // CRUD das Bebidas
    @GetMapping("/findAllBebidas")
    public List<BebidasModel> findAll() {
        return bebidasRepository.findAll();
    }

    @PostMapping("/createBebidas")
    public BebidasModel createBebida(@RequestBody BebidasModel bebida) {
        return bebidasRepository.save(bebida);
    }

    @DeleteMapping("/deleteBebidas/{id}")
    public void deleteBebida(@PathVariable Long id) {
        bebidasRepository.deleteById(id);
    }

    @PutMapping("/updateBebida")
    public ResponseEntity<BebidasModel> updateBebida(@RequestBody BebidasModel bebida) {
        return bebidasRepository.findById(bebida.getId())
                .map(bebidaExistente -> {
                    bebidaExistente.setDescricao(bebida.getDescricao());
                    bebidaExistente.setPreco_uni(bebida.getPreco_uni());
                    bebidaExistente.setZero_acucar(bebida.isZero_acucar());
                    bebidaExistente.setAtivo(bebida.getAtivo());
                    BebidasModel atualizado = bebidasRepository.save(bebidaExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
