package com.SalutemBurguer.Backend.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredientes")
@Getter
@Setter
public class IngredientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, length = 200)
    private BigDecimal preco_uni;

    @Column(nullable = false, length = 200)
    private boolean adicional;

    private Boolean ativo = true;

}
