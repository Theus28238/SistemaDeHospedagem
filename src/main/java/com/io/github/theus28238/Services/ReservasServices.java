package com.io.github.theus28238.Services;

import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.DTOs.QuartosDTO;
import com.io.github.theus28238.Entity.DTOs.ReservasDTO;
import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Execeptions.Guests.GuestNotFoundExeption;
import com.io.github.theus28238.Execeptions.Reservations.ReservationAlreadyRegister;
import com.io.github.theus28238.Execeptions.quartos.RoomNotFound;
import com.io.github.theus28238.Repository.HospedesRepositorys;
import com.io.github.theus28238.Repository.QuartoRepository;
import com.io.github.theus28238.Repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasServices {
    private final ReservaRepository reservaRepository;

    private final HospedesRepositorys  hospedesRepositorys;

    private final QuartoRepository  quartoRepository;

    public ReservasServices(ReservaRepository reservaRepository, HospedesRepositorys hospedesRepositorys, QuartoRepository quartoRepository) {
        this.reservaRepository = reservaRepository;
        this.hospedesRepositorys = hospedesRepositorys;
        this.quartoRepository = quartoRepository;
    }


    public void salvarReserva(ReservasDTO reservasDTO){

        var hospedes = hospedesRepositorys.findByCpf(reservasDTO.getHospede().getCpf())
                .orElseThrow(GuestNotFoundExeption::new);

        var quartos = quartoRepository.findByNumeroQuarto(reservasDTO.getQuartos().getNumeroQuarto())
                .orElseThrow(RoomNotFound::new);

        if (reservaRepository.reservaExiste(reservasDTO.getQuartos()
                .getNumeroQuarto(),reservasDTO
                .getCheckin(), reservasDTO.getCheckout())){
            throw new ReservationAlreadyRegister();
        }

        if (!quartos.getAtivo()){
            throw new RoomNotFound();
        }

        ReservasEntity reservasEntity = new ReservasEntity();
        reservasEntity.setHospedes(hospedes);
        reservasEntity.setQuarto(quartos);
        reservasEntity.setNumeroDePessoas(reservasDTO.getNumeroDePessoas());
        reservasEntity.setCheckin(reservasDTO.getCheckin());
        reservasEntity.setCheckout(reservasDTO.getCheckout());

       reservaRepository.save(reservasEntity);
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
