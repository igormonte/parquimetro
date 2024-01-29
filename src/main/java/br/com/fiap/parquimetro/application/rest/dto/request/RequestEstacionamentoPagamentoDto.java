package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public record RequestEstacionamentoPagamentoDto (

        @NotNull
        FormaPagamentoEnum formaPagamento,

        RequestEstacionamentoPagamentoCartaoDto cartao
){}

