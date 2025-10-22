package com.io.github.theus28238.Services;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.DTOs.ReservasDTO;
import com.io.github.theus28238.Entity.Hospedes;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasServices {
    @Autowired
    private ReservaRepository reservaRepository;

    private Hospedes hospedes;

    public ReservasEntity salvarReserva(ReservasEntity reservasEntity){
       return reservaRepository.save(reservasEntity);
    }

    public void deletarReserva(String numeroQuarto){
        if(reservaRepository.findByNumeroQuarto(numeroQuarto).isEmpty()){
            throw new RuntimeException("Essa reserva não existe.");
        }
        reservaRepository.deleteByNumeroQuarto(numeroQuarto);
    }

    public List<ReservasDTO> reservasRecentes(){
        List<ReservasEntity> reservasEntity = reservaRepository.findAllByOrderByCheckinDesc();

        List<ReservasDTO> reservasDTO = new ArrayList<>();

        for(ReservasEntity reservasEntity1 : reservasEntity){
            HospedesDTO hospedesDTO = new HospedesDTO(
                    reservasEntity1.getHospedes().getNome(),
                    reservasEntity1.getHospedes().getCpf(),
                    reservasEntity1.getHospedes().getTelefone()
            );



            ReservasDTO DTO = new ReservasDTO(
                    reservasEntity1.getNumeroQuarto(),
                    reservasEntity1.getAcomodacao(),
                    reservasEntity1.getNumeroDePessoas(),
                    reservasEntity1.getCheckout(),
                    reservasEntity1.getCheckin(),
                    hospedesDTO
            );

            reservasDTO.add(DTO);
        }
        return reservasDTO;
    }

}
