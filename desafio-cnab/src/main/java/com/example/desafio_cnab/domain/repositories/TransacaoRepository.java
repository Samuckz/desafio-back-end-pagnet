package com.example.desafio_cnab.domain.repositories;

import com.example.desafio_cnab.domain.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
}
