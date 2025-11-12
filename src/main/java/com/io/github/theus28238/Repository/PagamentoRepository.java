package com.io.github.theus28238.Repository;


import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Entity.business.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
    Optional<Pagamento> findByReservas_Id(UUID reservasId);
}
