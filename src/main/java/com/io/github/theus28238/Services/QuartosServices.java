package com.io.github.theus28238.Services;

import com.io.github.theus28238.Entity.DTOs.list.QuartosDTOList;
import com.io.github.theus28238.Entity.Quartos;
import com.io.github.theus28238.Execeptions.quartos.RoomAlreadyRegisteredException;
import com.io.github.theus28238.Execeptions.quartos.RoomNotFound;
import com.io.github.theus28238.Repository.QuartoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuartosServices {

    private final QuartoRepository quartoRepository;

    public QuartosServices(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }


    public void newQuarto(Quartos quartos){

        if (quartoRepository.findByNumeroQuarto(quartos.getNumeroQuarto()).isPresent()){
            throw new RoomAlreadyRegisteredException();
        }
        quartoRepository.save(quartos);
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
        List<Quartos> quartos = quartoRepository.findAll();

        List<QuartosDTOList> quartosDTOList = new ArrayList<>();

        for (Quartos quarto : quartos){
            QuartosDTOList dto = new QuartosDTOList(
                    quarto.getNumeroQuarto(),
                    quarto.getTipoQuarto(),
                    quarto.getAtivo()
            );
            quartosDTOList.add(dto);
        }
        return quartosDTOList;
    }


}
