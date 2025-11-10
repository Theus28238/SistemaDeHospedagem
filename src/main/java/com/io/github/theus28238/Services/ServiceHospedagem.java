package com.io.github.theus28238.Services;


import com.io.github.theus28238.Entity.DTOs.HospedesDTO;
import com.io.github.theus28238.Entity.Hospedes;
import com.io.github.theus28238.Execeptions.Guests.GuestAlreadyRegisterExeption;
import com.io.github.theus28238.Execeptions.Guests.GuestNotFoundExeption;
import com.io.github.theus28238.Repository.HospedesRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceHospedagem {

    @Autowired
    HospedesRepositorys hospedesRepositorys;

    public void cadastroDeHospede(Hospedes hospedesEntity){

        if (hospedesRepositorys.findByCpf(hospedesEntity.getCpf()).isPresent() ){
            throw new GuestAlreadyRegisterExeption();
        }

        hospedesRepositorys.save(hospedesEntity);
    }

    public void removerHospede( String cpf){
        if (hospedesRepositorys.findByCpf(cpf).isEmpty() ){
            throw new GuestNotFoundExeption();
        }
        hospedesRepositorys.deleteByCpf(cpf);
    }

    public void atualizarHospedePorCpf(Hospedes hospedes){
        Optional<Hospedes> hospedesOptional = hospedesRepositorys.findByCpf(hospedes.getCpf());
        if (hospedesOptional.isEmpty()){
            throw new GuestNotFoundExeption();
        }
        Hospedes hospedes1 = hospedesOptional.get();
            if (hospedes.getNome() != null){
                hospedes1.setNome(hospedes.getNome());
            }
            if (hospedes.getTelefone() != null){
                hospedes1.setTelefone(hospedes.getTelefone());
            }
        hospedesRepositorys.save(hospedes1);
    }

    public Hospedes pesquisandoHospede(String cpf){
        if (hospedesRepositorys.findByCpf(cpf).isEmpty() ){
            throw new GuestNotFoundExeption();
        }
        return  hospedesRepositorys.findByCpf(cpf).orElse(null);

    }

    public List<HospedesDTO> listaHospede(){
        List<Hospedes> hospedes =  hospedesRepositorys.findAllByOrderByNomeAsc();

        List<HospedesDTO> hospedesDTO = new ArrayList<>();

        for (Hospedes hospede : hospedes){

            HospedesDTO DTO = new HospedesDTO(
                    hospede.getNome(),
                    hospede.getTelefone(),
                    hospede.getCpf()
                    );
            hospedesDTO.add(DTO);

        }
        return hospedesDTO;
    }
}
