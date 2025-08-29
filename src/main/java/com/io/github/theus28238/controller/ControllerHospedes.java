package com.io.github.theus28238.controller;

import com.io.github.theus28238.entitysHospedes.Hospedes;
import com.io.github.theus28238.servicesHospedes.ServiceHospedagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/new-guest")
public class ControllerHospedes {

    @Autowired
    ServiceHospedagem serviceHospedagem;


    @PostMapping("sigin-guest")
    public void cadastroDeHospede(@RequestBody Hospedes hospedesEntity){
        serviceHospedagem.cadastroDeHospede(hospedesEntity);
    }

    @DeleteMapping("delete-guest")
    public void deletarHospede(@RequestBody Hospedes hospedes){
        serviceHospedagem.removerHospede(hospedes);
    }

    @PatchMapping("update-guest")
    public void atualizarHospede(@RequestBody Hospedes hospedes){
        serviceHospedagem.atualizarHospedePorCpf(hospedes.getCpf(), hospedes);
    }

    @GetMapping("search-guest/{cpf}")
    public Hospedes pesquisandoPorNome(@PathVariable("cpf") String cpf){
        return serviceHospedagem.pesquisandoHospede(cpf);
    }
}
