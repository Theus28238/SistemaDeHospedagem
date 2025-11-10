package com.io.github.theus28238.Services;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.DTOs.QuartosDTO;
import com.io.github.theus28238.Entity.DTOs.ReservasDTO;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Execeptions.Reservations.ReservationAlreadyRegister;
import com.io.github.theus28238.Execeptions.quartos.RoomNotFound;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasServices {
    @Autowired
    private ReservaRepository reservaRepository;


    public ReservasEntity salvarReserva(ReservasEntity reservasEntity){
        if (reservaRepository.reservaExiste(reservasEntity.getQuarto().getNumeroQuarto(),reservasEntity.getCheckin())){
            throw new ReservationAlreadyRegister();
        }

       return reservaRepository.save(reservasEntity);
    }

    public void deletarReserva(ReservasEntity reservasEntity){
        if(reservaRepository.findByQuarto_NumeroQuarto(reservasEntity.getQuarto().getNumeroQuarto()).isEmpty()){
            throw new RoomNotFound();
        }
        reservaRepository.deleteByQuarto_NumeroQuarto(reservasEntity.getQuarto().getNumeroQuarto());
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


            QuartosDTO quartosDTO = new QuartosDTO(
                    reservasEntity1.getQuarto().getNumeroQuarto()
            );



            ReservasDTO DTO = new ReservasDTO(
                    reservasEntity1.getNumeroDePessoas(),
                    reservasEntity1.getCheckout(),
                    reservasEntity1.getCheckin(),
                    hospedesDTO,
                    quartosDTO
            );

            reservasDTO.add(DTO);
        }
        return reservasDTO;
    }

}
