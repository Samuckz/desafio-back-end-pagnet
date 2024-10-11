package com.example.desafio_cnab.domain.dtos.transacao;

import com.example.desafio_cnab.utils.enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransacaoResponseDTO(
  UUID id,
  TipoTransacao tipoTransacao,
  LocalDate dataTransacao,
  BigDecimal valor,
  String nomeLoja

) {
}
