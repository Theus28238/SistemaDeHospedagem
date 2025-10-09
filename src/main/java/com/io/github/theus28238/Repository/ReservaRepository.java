package com.io.github.theus28238.Repository;

import com.io.github.theus28238.Entity.ReservasEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<ReservasEntity, UUID> {

    Optional<ReservasEntity> findByNumeroQuarto(String numeroQuarto );

    @Transactional
    void deleteByNumeroQuarto(String numeroQuarto);

}
