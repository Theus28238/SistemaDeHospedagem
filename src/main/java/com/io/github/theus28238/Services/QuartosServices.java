package com.io.github.theus28238.Services;

import com.io.github.theus28238.Entity.DTOs.QuartosDTO;
import com.io.github.theus28238.Entity.DTOs.QuartosDTOList;
import com.io.github.theus28238.Entity.Quartos;
import com.io.github.theus28238.Execeptions.quartos.RoomAlreadyRegisteredException;
import com.io.github.theus28238.Execeptions.quartos.RoomNotFound;
import com.io.github.theus28238.Repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuartosServices {

    @Autowired
    private QuartoRepository quartoRepository;


    public void newQuarto(Quartos quartos){

        if (quartoRepository.findByNumeroQuarto(quartos.getNumeroQuarto()).isPresent()){
            throw new RoomAlreadyRegisteredException();
        }
        quartos = quartoRepository.save(quartos);
    }

    public void desableQuartos(Integer numeroQuarto){

         var optional = quartoRepository.findByNumeroQuarto(numeroQuarto);

        if (optional.isEmpty()){
            throw new RoomNotFound();
        }

        Quartos quartos = optional.get();
        quartos.setAtivo(false);
        quartoRepository.save(quartos);
    }



    public List<QuartosDTOList> listaQuarto(){
        List<Quartos> quartos = quartoRepository.findAllByAtivo(true);

        List<QuartosDTOList> quartosDTOList = new ArrayList<>();

        for (Quartos quarto : quartos){
            QuartosDTOList dto = new QuartosDTOList(
                    quarto.getNumeroQuarto(),
                    quarto.getTipoQuarto(),
                    quarto.getValorQuarto(),
                    quarto.getAtivo()
            );
            quartosDTOList.add(dto);
        }
        return quartosDTOList;
    }


}
