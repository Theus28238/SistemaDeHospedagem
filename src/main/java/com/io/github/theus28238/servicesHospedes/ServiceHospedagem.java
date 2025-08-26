package com.io.github.theus28238.servicesHospedes;


import com.io.github.theus28238.entitysHospedes.Hospedes;
import com.io.github.theus28238.repositorys.HospedesRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void removerHospode(Hospedes hospedes){
        hospedesRepositorys.deleteByCpf(hospedes.getCpf());
    }
}
