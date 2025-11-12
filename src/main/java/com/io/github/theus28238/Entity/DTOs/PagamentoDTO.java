package com.io.github.theus28238.Entity.DTOs;

import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Entity.Stats.MetodoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private BigDecimal valor;
    private ReservasEntity reservas;
    private MetodoPagamento metodoPagamento;
    private Boolean statusPagamento;

}
