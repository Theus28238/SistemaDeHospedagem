package com.io.github.theus28238.Entity.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuartosDTOList {
    private Integer numeroQuarto;
    private String tipoQuarto;
    private BigDecimal valorQuarto;
    private Boolean ativo;
}
