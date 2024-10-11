package com.example.desafio_cnab.domain.dtos.transacao;

import org.springframework.web.multipart.MultipartFile;

public record CadastrarTransacoesDTO(
  MultipartFile file
) {
}
