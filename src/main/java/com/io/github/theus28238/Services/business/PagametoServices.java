package com.io.github.theus28238.Services.business;

import com.io.github.theus28238.Entity.DTOs.PagamentoDTO;
import com.io.github.theus28238.Entity.business.Pagamento;
import com.io.github.theus28238.Execeptions.Reservations.ReservationNotFoundExeception;
import com.io.github.theus28238.Execeptions.pagamentos.AlreadyPaidExeception;
import com.io.github.theus28238.Execeptions.pagamentos.PaidNotFoundExeception;
import com.io.github.theus28238.Repository.PagamentoRepository;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PagametoServices {




    private final ReservaRepository reservaRepository;
    private final PagamentoRepository pagamentoRepository;
    public PagametoServices(ReservaRepository reservaRepository1, PagamentoRepository pagamentoRepository) {
        this.reservaRepository = reservaRepository1;
        this.pagamentoRepository = pagamentoRepository;
    }

    public void criarPagamento(PagamentoDTO pagamentoDTO) {

        var reserva = reservaRepository.findByHospedes_CpfAndQuarto_NumeroQuartoAndCheckin(
                        pagamentoDTO.getReservas().getHospedes().getCpf(),
                        pagamentoDTO.getReservas().getQuarto().getNumeroQuarto(),
                        pagamentoDTO.getReservas().getCheckin())
                        .orElseThrow(ReservationNotFoundExeception::new);

        var pagamentoExiste = pagamentoRepository.findByReservas_Id(reserva.getId());

        if (pagamentoExiste.isPresent() && Boolean.TRUE.equals(pagamentoExiste.get().getReservas().getStatusPagamento())){
             throw new AlreadyPaidExeception();
        }
        Pagamento pagamento = new Pagamento();

        pagamento.setReservas(reserva);
        pagamento.setMetodoPagamento(pagamentoDTO.getMetodoPagamento());
        pagamento.getReservas().setStatusPagamento(true);
        pagamento.setData(pagamentoDTO.getData());
        pagamento.setValor(pagamentoDTO.getValor());

        pagamentoRepository.save(pagamento);
    }

    public void deletePagamento(UUID pagamentoId) {
        var pagamento = pagamentoRepository.findById(pagamentoId);
        if (pagamento.isEmpty()) {
            throw new PaidNotFoundExeception();
        }
        pagamento.get().getReservas().setStatusPagamento(false);

        pagamentoRepository.deleteById(pagamentoId);
    }




}
