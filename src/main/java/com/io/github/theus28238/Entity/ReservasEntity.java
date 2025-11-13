package com.io.github.theus28238.Entity;

import com.io.github.theus28238.Entity.business.Pagamento;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_reservas")
public class ReservasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "codigo")
    private UUID id;

    @Column(name = "numerodepessoas")
    private Integer numeroDePessoas;
    private LocalDate checkin;
    private LocalDate checkout;

    @Column(nullable = false)
    private Boolean statusPagamento = false;

    @ManyToOne
    @JoinColumn(name = "idhospedes", nullable = false)
    private Hospedes hospedes;

    @ManyToOne
    @JoinColumn(name = "id_quarto", nullable = false)
    private Quartos quarto;

    @OneToMany(mappedBy = "reservas",  cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;
}
