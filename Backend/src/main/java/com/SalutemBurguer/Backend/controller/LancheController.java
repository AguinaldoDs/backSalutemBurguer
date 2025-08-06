package com.SalutemBurguer.Backend.controller;
import com.SalutemBurguer.Backend.model.LancheModel;
import com.SalutemBurguer.Backend.repository.IngredientesRepository;
import com.SalutemBurguer.Backend.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
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



}
