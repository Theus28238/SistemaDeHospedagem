package com.io.github.theus28238.Services.reservas;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.DTOs.QuartosDTO;
import com.io.github.theus28238.Entity.DTOs.ReservasDTO;
import com.io.github.theus28238.Entity.DTOs.list.HospedesLisDTO;
import com.io.github.theus28238.Entity.DTOs.list.ReservaListDTO;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaMap {

    private final ReservaRepository reservaRepository;

    public ReservaMap(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaListDTO> listarReservasNaoFeita(){

        List<ReservasEntity> reservasEntities = reservaRepository.findReservaNaoPaga();

        ArrayList<ReservaListDTO> reservasListDTO = new ArrayList<>();

        for (ReservasEntity reserva : reservasEntities) {
            HospedesLisDTO hospedesLisDTO = new HospedesLisDTO(
                    reserva.getHospedes().getNome()
            );

            ReservaListDTO reservaListDTO = new ReservaListDTO(
                    reserva.getCheckin(),
                    reserva.getCheckout(),
                    reserva.getStatusPagamento(),
                    hospedesLisDTO
            );

            reservasListDTO.add(reservaListDTO);
        }
        return reservasListDTO;
    }


    public List<ReservasDTO> reservasRecentes(){
        List<ReservasEntity> reservasEntity = reservaRepository.findReservasDoMes();

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
                    reservasEntity1.getCheckin(),
                    reservasEntity1.getCheckout(),
                    hospedesDTO,
                    quartosDTO
            );

            reservasDTO.add(DTO);
        }
        return reservasDTO;
    }

}
