package com.io.github.theus28238.Entity.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservasDTO {
    private String numeroQuarto;
    private String acomodacao;
    private int numeroDePessoas;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private HospedesDTO hospede;
}
