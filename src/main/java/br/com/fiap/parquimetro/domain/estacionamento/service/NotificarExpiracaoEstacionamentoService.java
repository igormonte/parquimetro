package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.repository.ConsultaEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.NotificarExpiracaoEstacionamento;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NotificarExpiracaoEstacionamentoService implements NotificarExpiracaoEstacionamento {

    ConsultaEstacionamento consultaEstacionamento;

    public NotificarExpiracaoEstacionamentoService(
            ConsultaEstacionamento consultaEstacionamento) {
        this.consultaEstacionamento = consultaEstacionamento;
    }

    @Override
    public void executar(Estacionamento estacionamento) {

        log.warn(
                String.format("Atenção %s \n" +
                                "Seu estacionamento expirou!",
                        estacionamento.getCondutor().getNome())
        );

    }
}
