package com.io.github.theus28238.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "quarto")
public class Quartos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_quarto;

    @Column(name = "numero_quarto")
    private Integer numeroQuarto;

    @Column(name = "tipo_quarto")
    private String tipoQuarto;

    private Boolean ativo;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<ReservasEntity>  reservas;

}
