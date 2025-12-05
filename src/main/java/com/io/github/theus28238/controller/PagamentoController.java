package com.io.github.theus28238.controller;

import com.io.github.theus28238.Entity.DTOs.PagamentoDTO;
import com.io.github.theus28238.Entity.DTOs.list.PagamentoListDTO;
import com.io.github.theus28238.Services.business.MapPagamento;
import com.io.github.theus28238.Services.business.PagametoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagametoServices pagametoServices;

    @Autowired
    private MapPagamento mapPagamento;

    @PostMapping
    public void criarPagamento(@RequestBody PagamentoDTO pagamentoDTO){
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        pagametoServices.criarPagamento(pagamentoDTO);
    }

    @DeleteMapping("/{pagamentoId}")
    public void deletePagamento(@PathVariable UUID pagamentoId){
        pagametoServices.deletePagamento(pagamentoId);
    }

    @GetMapping
    public List<PagamentoListDTO> listarPagamentoRecente(){
        return mapPagamento.listarPagamentosRecentes();
    }
}
