package br.com.fiap.parquimetro.application.rest.dto.request;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Cartao;

public record RequestEstacionamentoPagamentoCartaoDto(
        String numeroCartao,
        String nomeTitular,
        String cvv
){}

