package br.com.fiap.parquimetro.application.rest.dto.response;

import jakarta.validation.constraints.NotNull;

public record ResponseEstacionamentoVeiculoDto(
    String uuid,
    String placa,
    String nome

){}
