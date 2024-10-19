package com.example.desafio_cnab.domain.models;

import com.example.desafio_cnab.utils.enums.TipoTransacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_movimentacoes_financeiras")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transacao implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "tipo_transacao", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private TipoTransacaoEnum tipoTransacaoEnum;

  @Column(name = "data_transacao", nullable = false)
  private LocalDate dataTransacao;

  @Column(nullable = false)
  private BigDecimal valor;

  @Column(name = "cpf_benefeciario", nullable = false)
  private String cpfBeneficiario;

  @Column(nullable = false)
  private String cartao;

  @Column(nullable = false)
  private Time horario;

  @Column(name = "dono_loja", nullable = false)
  private String donoLoja;

  @Column(name = "nome_loja", nullable = false)
  private String nomeLoja;

  public Transacao(
    TipoTransacaoEnum tipoTransacaoEnum,
    LocalDate dataTransacao,
    BigDecimal valor,
    String cpfBeneficiario,
    String cartao,
    Time horario,
    String donoLoja,
    String nomeLoja) {
    this.tipoTransacaoEnum = tipoTransacaoEnum;
    this.dataTransacao = dataTransacao;
    this.valor = valor;
    this.cpfBeneficiario = cpfBeneficiario;
    this.cartao = cartao;
    this.horario = horario;
    this.donoLoja = donoLoja;
    this.nomeLoja = nomeLoja;
  }
}
