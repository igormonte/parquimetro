package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.stream.Collectors;

public record RequestCondutorDto(
    @NotNull
    String nome,
    @Email
    String email,
    @CPF
    String cpf,
    @NotNull
    String senha,
    @NotNull
    FormaPagamentoEnum formaPagamentoPadrao,
    @NotNull
    RequestEnderecoDto endereco,
    @NotEmpty
    List<RequestVeiculoDto> veiculo

){}
