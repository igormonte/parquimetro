package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.repository.ConsultaEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.FinalizarEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.NotificarExpiracaoEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarFechamentoEstacionamento;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RealizarFechamentoEstacionamentoService implements RealizarFechamentoEstacionamento {

    private ConsultaEstacionamento consultaEstacionamento;
    private FinalizarEstacionamento finalizarEstacionamento;
    private NotificarExpiracaoEstacionamento notificarExpiracaoEstacionamento;


    public RealizarFechamentoEstacionamentoService(
            ConsultaEstacionamento consultaEstacionamento,
            FinalizarEstacionamento finalizarEstacionamento,
            NotificarExpiracaoEstacionamento notificarExpiracaoEstacionamento) {
        this.consultaEstacionamento = consultaEstacionamento;
        this.finalizarEstacionamento = finalizarEstacionamento;
        this.notificarExpiracaoEstacionamento = notificarExpiracaoEstacionamento;
    }


    @Override
    public void executar() {

        List<Estacionamento> estacionamentoList =
                this.coletaEstacionamentosFixosEmAndamento();

        estacionamentoList.forEach(e->{

            try {

                if(this.verificaEstacionamentoExpirado(e)) {
                    Boolean resultado = this.finalizarEstacionamento.executar(e.getUuid());

                    if(resultado) {
                        this.notificarExpiracaoEstacionamento.executar(e);
                    }

                }

            } catch (Exception exception) {
                log.error(exception.getMessage());
            }


        });

    }

    private List<Estacionamento> coletaEstacionamentosFixosEmAndamento() {
        return this.consultaEstacionamento.findByStatusAndPeriodo(StatusEnum.EM_PROGRESSO, PeriodoEnum.FIXO);

    }

    private Boolean verificaEstacionamentoExpirado(Estacionamento estacionamento) {

        return estacionamento.isExpirado();

    }
}
