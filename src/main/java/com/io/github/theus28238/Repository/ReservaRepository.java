package com.io.github.theus28238.Repository;

import com.io.github.theus28238.Entity.ReservasEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<ReservasEntity, UUID> {

    Optional<ReservasEntity> findByQuarto_NumeroQuarto(Integer numeroQuarto);

    @Transactional
    void deleteByQuarto_NumeroQuarto(Integer numeroQuarto);

    List<ReservasEntity> findAllByOrderByCheckinDesc();


    @Query("""
       SELECT COUNT(r) > 0
       FROM ReservasEntity r
       WHERE r.quarto.numeroQuarto = :numeroQuarto
       AND (
            (:checkin BETWEEN r.checkin AND r.checkout)
            OR (:checkout BETWEEN r.checkin AND r.checkout)
            OR (r.checkin BETWEEN :checkin AND :checkout)
       )
       """)
    boolean reservaExiste(
            @Param("numeroQuarto") Integer numeroQuarto,
            @Param("checkin") LocalDate checkin,
            @Param("checkout") LocalDate checkout
    );

    Optional<ReservasEntity> findByHospedes_CpfAndQuarto_NumeroQuartoAndCheckin(String hospedesCpf, Integer quartoNumeroQuarto, LocalDate checkin);
}
