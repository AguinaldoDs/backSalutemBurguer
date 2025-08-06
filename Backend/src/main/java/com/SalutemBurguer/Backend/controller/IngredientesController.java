package com.SalutemBurguer.Backend.controller;

import com.SalutemBurguer.Backend.model.IngredientesModel;
import java.util.List;

import com.SalutemBurguer.Backend.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://192.168.0.23:4200", "*"})
@RestController
@RequestMapping("/api")
public class IngredientesController {


    @Autowired
    private IngredientesRepository ingredientesRepository;


    @GetMapping("/findAllIngredientesAtivos")
    public List<IngredientesModel> findAllIngredientesAtivos() {
        return ingredientesRepository.findByAtivoTrue();
    }


    // CRUD dos INGREDIENTES
    @GetMapping("/findAllIngredientes")
    public List<IngredientesModel> findAll() {
        return ingredientesRepository.findAll();
    }

    @PostMapping("/createIngredientes")
    public IngredientesModel createIngrediente(@RequestBody IngredientesModel ingrediente) {
        return ingredientesRepository.save(ingrediente);
    }

    @DeleteMapping("/deleteIngredientes/{id}")
    public void deleteIngrediente(@PathVariable Long id) {
        ingredientesRepository.deleteById(id);
    }

    @PutMapping("/updateIngrediente")
    public ResponseEntity<IngredientesModel> updateIngrediente(@RequestBody IngredientesModel ingrediente) {
        return ingredientesRepository.findById(ingrediente.getId())
                .map(ingredienteExistente -> {
                    ingredienteExistente.setDescricao(ingrediente.getDescricao());
                    ingredienteExistente.setPreco_uni(ingrediente.getPreco_uni());
                    ingredienteExistente.setAdicional(ingrediente.isAdicional());
                    ingredienteExistente.setAtivo(ingrediente.getAtivo());
                    IngredientesModel atualizado = ingredientesRepository.save(ingredienteExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
