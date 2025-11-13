package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.DTOs.ReservasDTO;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Services.reservas.ReservasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ReservasController {

    @Autowired
    private ReservasServices reservasServices;


    private ReservasEntity reservasEntity;

    @PostMapping("saving-reservation")
    public void salvingReservation(@RequestBody ReservasDTO reservasDTO){
        reservasServices.salvarReserva(reservasDTO);
    }

    @DeleteMapping("/deleting-reservation/{numeroQuarto}")
    public void deleting(@PathVariable("numeroQuarto") ReservasEntity reservasEntity ){
        reservasServices.deletarReserva(reservasEntity);
    }

    @GetMapping("/reservas-recentes")
    public List<ReservasDTO> listarReservas(){
        return reservasServices.reservasRecentes();
    }
}
