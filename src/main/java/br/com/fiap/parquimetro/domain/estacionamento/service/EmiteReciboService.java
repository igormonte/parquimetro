package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.EmiteRecibo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmiteReciboService implements EmiteRecibo {
    @Override
    public void executar(Estacionamento estacionamento) {
        log.info(String.format("\n*** RECIBO ***\n" +
                               "=================\n" +
                               "placa: %s\n" +
                               "tempo: %s\n" +
                               "tarifa: %s\n" +
                               "VALOR TOTAL: %s",
                estacionamento.getVeiculo().getPlaca(),
                estacionamento.getTempo().toString(),
                estacionamento.getValor().getTAXA().toString(),
                estacionamento.getValor().getValor().toString()));

    }
}
