package com.example.desafio_cnab.domain.services.especification;

import com.example.desafio_cnab.domain.models.TipoTransacao;

public interface TipoTransacaoService {
  TipoTransacao obterTipoTransacao(char tipoTransacao);
}
