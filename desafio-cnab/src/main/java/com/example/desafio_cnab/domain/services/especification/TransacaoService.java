package com.example.desafio_cnab.domain.services.especification;

import com.example.desafio_cnab.domain.dtos.transacao.TransacaoResponseDTO;
import com.example.desafio_cnab.domain.models.Transacao;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TransacaoService {
  TransacaoResponseDTO cadastrarTransacoes(MultipartFile cadastrarTransacoesDTO) throws IOException;

  List<Transacao> listarTransacoes();

  void clearDatabase();
}
