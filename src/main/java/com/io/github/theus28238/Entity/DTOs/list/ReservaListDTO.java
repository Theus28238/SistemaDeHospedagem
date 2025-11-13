package com.io.github.theus28238.Entity.DTOs.list;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaListDTO {
    private LocalDate checkin;
    private LocalDate checkout;
    private Boolean statusPagamento;
    private HospedesLisDTO hospede;
}
