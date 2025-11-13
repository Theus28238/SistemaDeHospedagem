package com.io.github.theus28238.Services.business;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.DTOs.PagamentoDTO;
import com.io.github.theus28238.Entity.DTOs.list.HospedesLisDTO;
import com.io.github.theus28238.Entity.DTOs.list.PagamentoListDTO;
import com.io.github.theus28238.Entity.DTOs.list.ReservaListDTO;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Entity.business.Pagamento;
import com.io.github.theus28238.Repository.PagamentoRepository;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MapPagamento {


    private final PagamentoRepository pagamentoRepository;
    public MapPagamento( PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<PagamentoListDTO> listarPagamentosRecentes(){
        List<Pagamento>  pagamentos = pagamentoRepository.findPagamentoMes();

        ArrayList<PagamentoListDTO> pagamentosListDTO = new ArrayList<>();

        for (Pagamento pagamento : pagamentos) {

            HospedesLisDTO hospedesLisDTO = new HospedesLisDTO(
                    pagamento.getReservas().getHospedes().getNome()
            );

            ReservaListDTO reservaListDTO = new ReservaListDTO(
                    pagamento.getReservas().getCheckin(),
                    pagamento.getReservas().getCheckout(),
                    pagamento.getReservas().getStatusPagamento(),
                    hospedesLisDTO
            );

            PagamentoListDTO pagamentoListDTO = new PagamentoListDTO(
                    pagamento.getId(),
                    pagamento.getValor(),
                    pagamento.getData(),
                    reservaListDTO,
                    pagamento.getMetodoPagamento()
            );

            pagamentosListDTO.add(pagamentoListDTO);

        }

        return pagamentosListDTO;

    }





}
