package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record RequestEstacionamentoCondutorDto(
    @NotNull
    String uuid

){}
