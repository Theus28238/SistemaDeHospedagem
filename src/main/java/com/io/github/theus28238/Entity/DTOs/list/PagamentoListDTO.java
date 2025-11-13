package com.io.github.theus28238.Entity.DTOs.list;

import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Entity.Stats.MetodoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PagamentoListDTO {
    private UUID id;
    private BigDecimal valor;
    private LocalDate data;
    private ReservaListDTO reservas;
    private MetodoPagamento metodoPagamento;

}
