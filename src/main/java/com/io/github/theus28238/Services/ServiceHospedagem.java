package com.io.github.theus28238.Services;


import com.io.github.theus28238.Entity.Hospedes;
import com.io.github.theus28238.Repository.HospedesRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceHospedagem {

    @Autowired
    HospedesRepositorys hospedesRepositorys;

    public void cadastroDeHospede(Hospedes hospedesEntity){

        if (hospedesRepositorys.findByCpf(hospedesEntity.getCpf()).isPresent() ){
            throw new RuntimeException("Este hospede já está cadastrata");
        }

        hospedesRepositorys.save(hospedesEntity);
    }

    public void removerHospede(Hospedes hospedes){
        hospedesRepositorys.deleteByCpf(hospedes.getCpf());
    }

    public void atualizarHospedePorCpf(String cpf ,Hospedes hospedes){
        Optional<Hospedes> hospedesOptional = hospedesRepositorys.findByCpf(cpf);
        if (hospedesOptional.isEmpty()){
            throw new RuntimeException("Este não existe");
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
        return  hospedesRepositorys.findByCpf(cpf).orElse(null);

    }
}
