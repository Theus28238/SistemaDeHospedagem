package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.Hospedes;
import com.io.github.theus28238.Services.ServiceHospedagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospede")
public class ControllerHospedes {

    @Autowired
    ServiceHospedagem serviceHospedagem;

    @PostMapping
    public void cadastroDeHospede(@RequestBody Hospedes hospedesEntity) {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        serviceHospedagem.cadastroDeHospede(hospedesEntity);
    }

    @DeleteMapping("{cpf}")
    public void deletarHospede(@PathVariable String cpf) {
        serviceHospedagem.removerHospede(cpf);
    }

    @PatchMapping
    public void atualizarHospede(@RequestBody Hospedes hospedes) {
        System.out.println("CPF recebido: " + hospedes.getCpf());
        System.out.println("Nome recebido: " + hospedes.getNome());
        System.out.println("Telefone recebido: " + hospedes.getTelefone());
        serviceHospedagem.atualizarHospedePorCpf(hospedes);
    }

    @GetMapping("{cpf}")
    public Hospedes pesquisandoPorNome(@PathVariable("cpf") String cpf) {
        return serviceHospedagem.pesquisandoHospede(cpf);
    }

    @GetMapping("hospedes-list")
    public List<HospedesDTO> listarhospedes() {
        return serviceHospedagem.listaHospede();
    }
}
