package com.SalutemBurguer.Backend.repository;

import com.SalutemBurguer.Backend.model.LancheModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancheRepository extends JpaRepository<LancheModel, Long> {
}
