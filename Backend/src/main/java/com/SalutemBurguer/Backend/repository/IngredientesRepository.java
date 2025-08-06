package com.SalutemBurguer.Backend.repository;

import com.SalutemBurguer.Backend.model.IngredientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientesRepository extends JpaRepository<IngredientesModel, Number> {

    List<IngredientesModel> findByAtivoTrue();
}
