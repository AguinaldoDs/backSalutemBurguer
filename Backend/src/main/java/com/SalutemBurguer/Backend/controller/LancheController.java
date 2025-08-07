package com.SalutemBurguer.Backend.controller;
import com.SalutemBurguer.Backend.model.LancheModel;
import com.SalutemBurguer.Backend.repository.IngredientesRepository;
import com.SalutemBurguer.Backend.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lanche")
public class LancheController {

    @Autowired
    private LancheRepository lancheRepository;

    @GetMapping("/findAllLanche")
    private List<LancheModel> findAllLanche() {
        return lancheRepository.findAll();
    }

    @PostMapping("/saveLanche")
    public LancheModel saveLanche(@RequestBody LancheModel lanche) {
        return lancheRepository.save(lanche);
    }

    @DeleteMapping("/deleteLanche/{id}")
    public void deleteLanche(@PathVariable Long id) {
        lancheRepository.deleteById(id);
    }


    @PutMapping("/updateLanche")
    public ResponseEntity<LancheModel> updateLanche(@RequestBody LancheModel lanche) {
        return lancheRepository.findById(lanche.getId())
                .map(lancheExistente -> {

                    lancheExistente.setDescricao(lanche.getDescricao());
                    lancheExistente.setAtivo(lanche.isAtivo());

                    lancheExistente.getIngredientes().clear();

                    if (lanche.getIngredientes() != null) {
                        lanche.getIngredientes().forEach(item -> item.setLanche(lancheExistente));
                        lancheExistente.getIngredientes().addAll(lanche.getIngredientes());
                    }

                    LancheModel atualizado = lancheRepository.save(lancheExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
