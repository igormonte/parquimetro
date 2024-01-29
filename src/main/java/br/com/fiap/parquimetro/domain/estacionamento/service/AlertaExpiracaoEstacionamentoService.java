package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.repository.AlertaExpiracaoEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.ConsultaEstacionamento;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class AlertaExpiracaoEstacionamentoService implements AlertaExpiracaoEstacionamento {

    ConsultaEstacionamento consultaEstacionamento;

    public AlertaExpiracaoEstacionamentoService(ConsultaEstacionamento consultaEstacionamento) {
        this.consultaEstacionamento = consultaEstacionamento;
    }

    @Override
    public void executar() {

        List<Estacionamento> estacionamentoList =
                this.coletaEstacionamentosFixosEmAndamento();

        estacionamentoList.forEach(e -> {

            if (this.verificaEstacionamentoTempoEstacionamentoAcabando(e)) {
                this.emiteAlerta(e);
            }

        });


    }

    private List<Estacionamento> coletaEstacionamentosFixosEmAndamento() {
        return this.consultaEstacionamento.findByStatusAndPeriodo(StatusEnum.EM_PROGRESSO, PeriodoEnum.FIXO);

    }

    private Boolean verificaEstacionamentoTempoEstacionamentoAcabando(Estacionamento estacionamento) {

        return estacionamento.getDataPrevisaoSaida().minusMinutes(10)
                .isBefore(LocalDateTime.now());

    }

    private void emiteAlerta(Estacionamento e) {

        log.warn(
                String.format("Atenção %s \n" +
                                "Seu estacionamento esta quase expirando!",
                        e.getCondutor().getNome())
        );


    }

}
