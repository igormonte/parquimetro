package br.com.fiap.parquimetro.application.rest.dto.response;

import jakarta.validation.constraints.NotNull;

public record ResponseEstacionamentoCondutorDto(
    String uuid,
    String nome

){}
