package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.repository.AlertaExpiracaoEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.AlertaTempoEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.ConsultaEstacionamento;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
public class AlertaTempoEstacionamentoService implements AlertaTempoEstacionamento {

    ConsultaEstacionamento consultaEstacionamento;

    public AlertaTempoEstacionamentoService(ConsultaEstacionamento consultaEstacionamento) {
        this.consultaEstacionamento = consultaEstacionamento;
    }

    @Override
    public void executar() {

        List<Estacionamento> estacionamentoList =
                this.coletaEstacionamentosVariaveisEmAndamento();

        estacionamentoList.forEach(e -> {

            if (this.verificaTempoEstacionamentoAcimaUmaHora(e)) {
                this.emiteAlerta(e);
            }

        });

    }

    private List<Estacionamento> coletaEstacionamentosVariaveisEmAndamento() {
        return this.consultaEstacionamento.findByStatusAndPeriodo(StatusEnum.EM_PROGRESSO, PeriodoEnum.VARIAVEL);

    }

    private Boolean verificaTempoEstacionamentoAcimaUmaHora(Estacionamento estacionamento) {

        long horas = ChronoUnit.HOURS.between(estacionamento.getDataCriacao(),
                LocalDateTime.now());

        return horas > 1;

    }

    private void emiteAlerta(Estacionamento estacionamento) {

        long horas = ChronoUnit.HOURS.between(estacionamento.getDataCriacao(),
                LocalDateTime.now());
        log.warn(
                String.format("Atenção %s \n" +
                                "Seu estacionamento está aberto a %d ou mais. \n\n" +
                                "" +
                                "Realize o fechamento do estacionameto para evitar uma cobrança excedente.",
                        estacionamento.getCondutor().getNome(), horas)
        );


    }

}
