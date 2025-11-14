package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.DTOs.ReservasDTO;
import com.io.github.theus28238.Entity.DTOs.list.ReservaListDTO;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Services.reservas.ReservaMap;
import com.io.github.theus28238.Services.reservas.ReservasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ReservasController {

    @Autowired
    private ReservasServices reservasServices;

    @Autowired
    private ReservaMap reservaMap;
    private ReservasEntity reservasEntity;

    @PostMapping
    public void salvingReservation(@RequestBody ReservasDTO reservasDTO){
        reservasServices.salvarReserva(reservasDTO);
    }

    @DeleteMapping("/{numeroQuarto}")
    public void deleting(@PathVariable("numeroQuarto") ReservasEntity reservasEntity ){
        reservasServices.deletarReserva(reservasEntity);
    }

    @GetMapping("/reservas-recentes")
    public List<ReservasDTO> listarReservas(){
        return reservaMap.reservasRecentes();
    }

    @GetMapping("/reserva-nao-feita")
    public List<ReservaListDTO> listarReservasNaoFeita(){
        return reservaMap.listarReservasNaoFeita();
    }
}
