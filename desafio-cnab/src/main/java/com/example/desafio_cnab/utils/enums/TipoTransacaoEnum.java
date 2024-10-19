package com.example.desafio_cnab.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoTransacaoEnum {
  DEBITO(1),
  BOLETO(2),
  FINANCIAMENTO(3),
  CREDITO(4),
  RECEBIMENTO_EMPRESTIMO(5),
  VENDAS(6),
  RECEBIMENTO_TED(7),
  RECEBIMENTO_DOC(8),
  ALUGUEL(9);

  private final int codigo;

  public static TipoTransacaoEnum getTipoTransacaoFromCodigo(int codigo){
    return Arrays.stream(TipoTransacaoEnum.values())
      .filter(tipo -> tipo.getCodigo() == codigo)
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("Tipo Transacao inválida: " + codigo));
  }
}
