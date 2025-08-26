package com.io.github.theus28238.entitysHospedes;


import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

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

}
