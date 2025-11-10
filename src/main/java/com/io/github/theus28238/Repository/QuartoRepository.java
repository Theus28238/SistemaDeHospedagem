package com.io.github.theus28238.Repository;

import com.io.github.theus28238.Entity.Quartos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuartoRepository extends JpaRepository<Quartos, UUID> {
    Optional<Quartos> findByNumeroQuarto(Integer numeroQuarto);

    void deleteByNumeroQuarto(Integer numeroQuarto);

    @Query("select quarto from Quartos quarto where quarto.ativo == true")
    List<Quartos> findAllByAtivo(Boolean ativo);
}
