package com.io.github.theus28238.Repository;


import com.io.github.theus28238.Entity.Hospedes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface HospedesRepositorys extends JpaRepository<Hospedes,UUID> {
    Optional<Hospedes> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);

}
