package com.io.github.theus28238.Repository;


import com.io.github.theus28238.Entity.ReservasEntity;
import com.io.github.theus28238.Entity.business.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {


    @Query("select p from Pagamento p where MONTH(p.data) = MONTH(CURRENT_DATE) and YEAR(p.data) = YEAR(CURRENT_DATE) ORDER BY p.data desc")
    List<Pagamento> findPagamentoMes();

    Optional<Pagamento> findByReservas_Id(UUID reservasId);
}
