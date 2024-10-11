package com.example.desafio_cnab.domain.services.especification;

import com.example.desafio_cnab.domain.dtos.transacao.TransacaoResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TransacaoService {
  public TransacaoResponseDTO cadastrarTransacoes(MultipartFile cadastrarTransacoesDTO) throws IOException;
}
