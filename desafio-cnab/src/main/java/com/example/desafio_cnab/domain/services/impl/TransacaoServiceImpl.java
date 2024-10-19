package com.example.desafio_cnab.domain.services.impl;

import com.example.desafio_cnab.domain.dtos.transacao.TransacaoResponseDTO;
import com.example.desafio_cnab.domain.models.Transacao;
import com.example.desafio_cnab.domain.repositories.TransacaoRepository;
import com.example.desafio_cnab.domain.services.especification.ParserService;
import com.example.desafio_cnab.domain.services.especification.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Service
public class TransacaoServiceImpl implements TransacaoService {

  @Autowired private ParserService parserService;
  @Autowired private TransacaoRepository transacaoRepository;
  @Override
  public TransacaoResponseDTO cadastrarTransacoes(MultipartFile file) throws IOException {
    try{
      BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
      String line;
      while(!Objects.isNull(line = bf.readLine())){
        Transacao transacao = parserService.parsaerStringToTransacao(line);
        transacaoRepository.save(transacao);

      }
    } catch (IOException exception){
      throw exception;
    }

    return null;
  }

  @Override
  public List<Transacao> listarTransacoes() {
    return transacaoRepository.findAll();
  }

  @Override
  public void clearDatabase() {
    transacaoRepository.deleteAll();
  }
}
