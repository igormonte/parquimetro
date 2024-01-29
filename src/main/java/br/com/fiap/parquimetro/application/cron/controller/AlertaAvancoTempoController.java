package br.com.fiap.parquimetro.application.cron.controller;

import br.com.fiap.parquimetro.domain.estacionamento.repository.AlertaTempoEstacionamento;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaAvancoTempoController {

    private AlertaTempoEstacionamento alertaTempoEstacionamento;

    public AlertaAvancoTempoController(AlertaTempoEstacionamento alertaTempoEstacionamento) {
        this.alertaTempoEstacionamento = alertaTempoEstacionamento;
    }

    @Scheduled(cron = "0 0/5 * * * *")
    private void executar(){
        this.alertaTempoEstacionamento.executar();
    }

}
