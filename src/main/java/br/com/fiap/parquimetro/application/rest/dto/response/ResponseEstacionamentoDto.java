package br.com.fiap.parquimetro.application.rest.dto.response;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.estacionamento.*;
import lombok.Data;

import java.math.BigDecimal;

public record ResponseEstacionamentoDto (
        String uuid,
        PeriodoEnum periodo,
        Long tempo,
        ResponseEstacionamentoCondutorDto condutor,
        ResponseEstacionamentoVeiculoDto veiculo,
        StatusEnum status,
        BigDecimal valor
) {
    public static ResponseEstacionamentoDto from(Estacionamento estacionamento) {
        Condutor condutor = estacionamento.getCondutor();
        Veiculo veiculo = estacionamento.getVeiculo();

        return new ResponseEstacionamentoDto(
                estacionamento.getUuid(),
                estacionamento.getPeriodo(),
                estacionamento.getTempo(),
                new ResponseEstacionamentoCondutorDto(
                        condutor.getUuid(),
                        condutor.getNome()),
                new ResponseEstacionamentoVeiculoDto(
                        veiculo.getUuid(),
                        veiculo.getNome(),
                        veiculo.getNome()),
                estacionamento.getStatus(),
                estacionamento.getValor() == null ? null
                        :estacionamento.getValor().getValor());
    }
}

