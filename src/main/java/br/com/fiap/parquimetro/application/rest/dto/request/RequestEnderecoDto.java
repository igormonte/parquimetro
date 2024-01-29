package br.com.fiap.parquimetro.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record RequestEnderecoDto(
    @NotNull
    String rua,
    @NotNull
    Integer numero,
    @NotNull
    String bairro,
    @NotNull
    String cidade,
    @NotNull
    String uf,
    @NotNull
    String cep

){}
