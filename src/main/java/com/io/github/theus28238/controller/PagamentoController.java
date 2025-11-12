package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.DTOs.PagamentoDTO;
import com.io.github.theus28238.Services.business.PagametoServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    private PagametoServices pagametoServices;

    @PostMapping
    public void atualizarPagamento(PagamentoDTO pagamentoDTO){
        pagametoServices.atualizarStatusPagamento(pagamentoDTO);
    }
}
