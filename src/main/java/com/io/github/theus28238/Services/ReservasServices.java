package com.io.github.theus28238.Services;

import com.io.github.theus28238.EntityReserva.ReservasEntity;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservasServices {
    @Autowired
    private ReservaRepository reservaRepository;


    public ReservasEntity salvarReserva(ReservasEntity reservasEntity){
       return reservaRepository.save(reservasEntity);
    }

    public void deletarReserva(String numeroQuarto){
        if(reservaRepository.findByNumeroQuarto(numeroQuarto).isEmpty()){
            throw new RuntimeException("Essa reserva não existe.");
        }
        reservaRepository.deleteByNumeroQuarto(numeroQuarto);
    }

}
