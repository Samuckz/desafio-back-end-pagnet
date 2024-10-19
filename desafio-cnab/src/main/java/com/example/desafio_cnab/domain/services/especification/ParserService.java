package com.example.desafio_cnab.domain.services.especification;

import com.example.desafio_cnab.domain.models.Transacao;

public interface ParserService {
  Transacao parsaerStringToTransacao(String transacao);
}
