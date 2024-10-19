package com.example.desafio_cnab.domain.controllers;

import com.example.desafio_cnab.domain.dtos.transacao.TransacaoResponseDTO;
import com.example.desafio_cnab.domain.models.Transacao;
import com.example.desafio_cnab.domain.services.especification.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/desafio-pagnet")
@Slf4j
public class TransacaoController {

  @Autowired
  private TransacaoService transacaoService;

  @GetMapping
  public ResponseEntity<String> creditos(){
    return ResponseEntity.ok("Desafio PagNet - By Samuel Santana");
  }

  @PostMapping("/cadastrar-transacoes")
  public ResponseEntity<TransacaoResponseDTO> cadastrarTransacoes(@RequestParam("file") MultipartFile file) throws IOException {
    TransacaoResponseDTO responseDTO = transacaoService.cadastrarTransacoes(file);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @GetMapping("/listar-transacoes")
  public List<Transacao> listarTransacao(){
    return transacaoService.listarTransacoes();
  }

  @GetMapping("/clear-database")
  public String limparBanco(){
    transacaoService.clearDatabase();
    return "banco limpo com sucesso!";
  }
}
