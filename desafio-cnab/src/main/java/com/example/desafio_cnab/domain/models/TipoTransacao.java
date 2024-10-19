package com.example.desafio_cnab.domain.models;

import com.example.desafio_cnab.utils.enums.TipoTransacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoTransacao {
  private int tipo;
  private TipoTransacaoEnum descricao;
  private boolean isEntrada;
}
