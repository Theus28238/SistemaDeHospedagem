package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Services.ReservasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class ReservasController {

    @Autowired
    private ReservasServices reservasServices;

    @PostMapping("saving-reservation")
    public ReservasEntity salvingReservation(@RequestBody ReservasEntity reservasEntity){
        return reservasServices.salvarReserva(reservasEntity);
    }

    @DeleteMapping("/deleting-reservation/{numeroQuarto}")
    public void deleting(@PathVariable("numeroQuarto") String numeroQuarto){
        reservasServices.deletarReserva(numeroQuarto);
    }

}
