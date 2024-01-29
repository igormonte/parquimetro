package br.com.fiap.parquimetro.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record RequestEstacionamentoVeiculoDto(
    @NotNull
    String uuid

){}
