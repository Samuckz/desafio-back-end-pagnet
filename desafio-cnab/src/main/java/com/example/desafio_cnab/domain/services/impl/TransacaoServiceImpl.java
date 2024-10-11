package com.example.desafio_cnab.domain.services.impl;

import com.example.desafio_cnab.domain.dtos.transacao.TransacaoResponseDTO;
import com.example.desafio_cnab.domain.services.especification.TransacaoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@Service
public class TransacaoServiceImpl implements TransacaoService {
  @Override
  public TransacaoResponseDTO cadastrarTransacoes(MultipartFile file) throws IOException {
    try{
      BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
      String line;
      while(!Objects.isNull(line = bf.readLine())){
        System.out.println(line);
      }
    } catch (IOException exception){
      throw exception;
    }

    return null;
  }
}
