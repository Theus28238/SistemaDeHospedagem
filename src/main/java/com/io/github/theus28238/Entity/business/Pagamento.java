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
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "codigo", nullable = false)
    private ReservasEntity reservas;

    private BigDecimal valor;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPagamento metodoPagamento;



}
