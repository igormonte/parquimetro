package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import jakarta.validation.constraints.NotNull;

public record RequestFinalizacaoEstacionamentoDto(
    @NotNull
    String uuid
){}

