package com.io.github.theus28238.entitysHospedes;


import com.io.github.theus28238.EntityReserva.ReservasEntity;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter

public class Hospedes   {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idhospedes")
    private UUID idHospedes;

    private String nome;

    private String cpf;

    private String telefone;

    @OneToMany(mappedBy = "hospedes")
    @Cascade(CascadeType.ALL)
    private List<ReservasEntity> reservasEntity;

}
