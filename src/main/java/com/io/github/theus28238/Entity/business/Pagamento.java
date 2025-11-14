package com.io.github.theus28238.Entity.business;

import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Entity.Stats.MetodoPagamento;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pagamento")
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "reservas", nullable = false)
    private ReservasEntity reservas;

    private BigDecimal valor;

    @Column(name = "data_pagamento")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pagamento",nullable = false)
    private MetodoPagamento metodoPagamento;



}
