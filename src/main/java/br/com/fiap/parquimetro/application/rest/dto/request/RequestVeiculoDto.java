package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import jakarta.validation.Valid;

public record RequestVeiculoDto(

    @Valid
    String placa,
    @Valid
    String nome

){}
