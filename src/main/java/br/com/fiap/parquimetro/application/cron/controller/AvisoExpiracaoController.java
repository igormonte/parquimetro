package br.com.fiap.parquimetro.application.cron.controller;

import br.com.fiap.parquimetro.domain.estacionamento.repository.AlertaExpiracaoEstacionamento;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AvisoExpiracaoController {

    private AlertaExpiracaoEstacionamento alertaExpiracaoEstacionamento;

    public AvisoExpiracaoController(
            AlertaExpiracaoEstacionamento alertaExpiracaoEstacionamento){
        this.alertaExpiracaoEstacionamento = alertaExpiracaoEstacionamento;
    }

    @Scheduled(cron = "0 0/15 * * * *")
    private void executar(){
        this.alertaExpiracaoEstacionamento.executar();
    }

}
