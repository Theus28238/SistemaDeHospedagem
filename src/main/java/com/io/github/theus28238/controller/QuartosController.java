package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.DTOs.QuartosDTO;
import com.io.github.theus28238.Entity.DTOs.QuartosDTOList;
import com.io.github.theus28238.Entity.Quartos;
import com.io.github.theus28238.Services.QuartosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quartos")
public class QuartosController {


    @Autowired
    private QuartosServices quartosServices;

    @PostMapping()
    public void newQuarto(@RequestBody Quartos quarto){
        quartosServices.newQuarto(quarto);
    }

    @PatchMapping("{numeroQuarto}")
    public void desableQuarto(@PathVariable("numeroQuarto") Integer numeroQuarto){
        quartosServices.desableQuartos(numeroQuarto);
    }

    @GetMapping
    public List<QuartosDTOList> getQuartos(){
        return quartosServices.listaQuarto();
    }

}
