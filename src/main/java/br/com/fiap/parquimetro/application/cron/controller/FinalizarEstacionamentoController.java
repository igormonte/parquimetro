package br.com.fiap.parquimetro.application.cron.controller;

import br.com.fiap.parquimetro.domain.estacionamento.repository.FinalizarEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarFechamentoEstacionamento;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FinalizarEstacionamentoController {

    private RealizarFechamentoEstacionamento realizarFechamentoEstacionamento;

    public FinalizarEstacionamentoController(
            RealizarFechamentoEstacionamento realizarFechamentoEstacionamento) {
        this.realizarFechamentoEstacionamento = realizarFechamentoEstacionamento;
    }

    @Scheduled(cron = "0 0/2 * * * *")
    private void executar(){
        this.realizarFechamentoEstacionamento.executar();
    }

}
