package com.io.github.theus28238.Services.reservas;

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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public void deletarReserva(Integer numeroQuarto, String cpf, LocalDate checkin){

        var reserva = reservaRepository.findByHospedes_CpfAndQuarto_NumeroQuartoAndCheckin(cpf, numeroQuarto,checkin);

        if(reserva.isEmpty()){
            throw new RoomNotFound();
        }
        reservaRepository.delete(reserva.get());
    }



}
