package com.example.desafio_cnab.domain.services.impl;

import com.example.desafio_cnab.domain.models.TipoTransacao;
import com.example.desafio_cnab.domain.services.especification.TipoTransacaoService;
import org.springframework.stereotype.Service;

@Service
public class TipoTransacaoServiceImpl implements TipoTransacaoService {
  @Override
  public TipoTransacao obterTipoTransacao(char tipoTransacao) {
    System.out.println(tipoTransacao);
    return null;
  }
}
