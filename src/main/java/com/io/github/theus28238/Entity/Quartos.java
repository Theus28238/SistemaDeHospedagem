package com.io.github.theus28238.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Quartos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_quarto;

    private Integer numero_quarto;

    private String tipo_quarto;

    private BigDecimal valor_quarto;



}
