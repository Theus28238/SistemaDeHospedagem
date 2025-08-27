package com.io.github.theus28238.EntityReserva;

import jakarta.persistence.*;
import lombok.Data;

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

    private String numeroQuarto;
    private String acomodacao;
    private int numeroDePessoas;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
}
