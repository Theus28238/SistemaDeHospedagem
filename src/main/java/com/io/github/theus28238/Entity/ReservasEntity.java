package com.io.github.theus28238.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_reservas")
public class ReservasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "codigo")
    private UUID id;

    @Column(name = "numeroquarto")
    private String numeroQuarto;
    private String acomodacao;
    @Column(name = "numerodepessoas")
    private int numeroDePessoas;
    private LocalDate checkin;
    private LocalDate checkout;

    @ManyToOne
    @JoinColumn(name = "idhospedes", nullable = false)
    private Hospedes hospedes;
}
