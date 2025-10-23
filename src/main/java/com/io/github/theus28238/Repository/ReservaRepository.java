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

    Optional<ReservasEntity> findByNumeroQuarto(String numeroQuarto );

    @Transactional
    void deleteByNumeroQuarto(String numeroQuarto);

    List<ReservasEntity> findAllByOrderByCheckinDesc();


    @Query("SELECT COUNT(r) > 0 FROM ReservasEntity r " +
            "WHERE r.numeroQuarto = :numeroQuarto " +
            "AND (:data BETWEEN r.checkin AND r.checkout)")
    boolean reservaExiste(
           @Param("numeroQuarto") String numeroQuarto,
           @Param("data") LocalDate checkin);
}
