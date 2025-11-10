package com.io.github.theus28238.Entity.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservasDTO {
    private int numeroDePessoas;
    private LocalDate checkin;
    private LocalDate checkout;
    private HospedesDTO hospede;
    private QuartosDTO quartos;
}
