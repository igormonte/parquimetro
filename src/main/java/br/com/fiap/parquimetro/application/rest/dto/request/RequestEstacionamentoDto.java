package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Valor;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

public record RequestEstacionamentoDto (
    @NotNull
    RequestEstacionamentoCondutorDto condutor,
    @NotNull
    RequestEstacionamentoVeiculoDto veiculo,
    @NotNull
    PeriodoEnum periodo,
    Long tempo,
    @NotNull
    RequestEstacionamentoPagamentoDto pagamento

){}

