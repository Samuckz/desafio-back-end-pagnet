package com.example.desafio_cnab.domain.services.impl;

import com.example.desafio_cnab.domain.models.Transacao;
import com.example.desafio_cnab.domain.services.especification.ParserService;
import com.example.desafio_cnab.domain.services.especification.TipoTransacaoService;
import com.example.desafio_cnab.utils.enums.TipoTransacaoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

import static com.example.desafio_cnab.utils.constantes.ParserConstantes.*;

@Service
@Slf4j
public class ParserServiceImpl implements ParserService {

  @Autowired private TipoTransacaoService tipoTransacaoService;
  @Override
  public Transacao parsaerStringToTransacao(String transacao) {
    log.info("Parsing String to Transacao");
    if(transacao.isBlank()){
      return null;
    }
    TipoTransacaoEnum tipoTransacaoEnum = obterTipoTransacao(transacao);
    LocalDate dataTransacao = obterDataTransacao(transacao.substring(INICIO_RANGE_DATA, FIM_RANGE_DATA));
    BigDecimal valor = obterValor(transacao.substring(INICIO_RANGE_VALOR, FIM_RANGE_VALOR));
    String cpfBeneficiario = transacao.substring(INICIO_RANGE_CPF, FIM_RANGE_CPF);
    String cartao = transacao.substring(INICIO_RANGE_CARTAO, FIM_RANGE_CARTAO);
    Time horario = obterHorario(transacao.substring(INICIO_RANGE_HORA, FIM_RANGE_HORA));
    String donoLoja = transacao.substring(INICIO_RANGE_DONO_LOJA, FIM_RANGE_DONO_LOJA).trim();
    String nomeLoja = transacao.substring(INICIO_RANGE_NOME_LOJA, FIM_RANGE_NOME_LOJA).trim();

    return new Transacao(
      tipoTransacaoEnum, dataTransacao, valor, cpfBeneficiario, cartao, horario, donoLoja, nomeLoja
    );
  }

  private TipoTransacaoEnum obterTipoTransacao(String transacao){

    int tipoTransacao = Integer.parseInt(String.valueOf(transacao.charAt(INDEX_TIPO_TRANSACAO)) );
    if (tipoTransacao < 1 || tipoTransacao > 9) {
      throw new IllegalArgumentException("Tipo de transação inválido: " + tipoTransacao);
    }
    return TipoTransacaoEnum.getTipoTransacaoFromCodigo(tipoTransacao);
  }
  private LocalDate obterDataTransacao(String data){
    int ano = Integer.parseInt(data.substring(0, 4));
    int mes = Integer.parseInt(data.substring(4,6));
    int dia = Integer.parseInt(data.substring(6, 8));

    return LocalDate.of(ano, mes, dia);
  }

  private BigDecimal obterValor(String valor){
    double value = Double.parseDouble(valor);
    return BigDecimal.valueOf(value).divide(BigDecimal.valueOf(100L));
  }

  private Time obterHorario(String hora){
    int horas = Integer.parseInt(hora.substring(0,1));
    int minutos = Integer.parseInt(hora.substring(2,3));
    int segundos = Integer.parseInt(hora.substring(4,5));

    return Time.valueOf(horas + ":" + minutos + ":" + segundos);
  }
}
