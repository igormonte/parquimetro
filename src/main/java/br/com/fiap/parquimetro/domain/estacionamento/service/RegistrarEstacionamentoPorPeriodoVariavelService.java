package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.exception.FormaPagamentoNaoHabilitadaParaPeriodosVariaveisException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.TempoPermanenciaNaoInformadoException;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamentoPorPeriodo;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;

import java.time.LocalDateTime;

public class RegistrarEstacionamentoPorPeriodoVariavelService implements RegistrarEstacionamentoPorPeriodo {

    private EstacionamentoService estacionamentoService;

    public RegistrarEstacionamentoPorPeriodoVariavelService(EstacionamentoService estacionamentoService){
        this.estacionamentoService = estacionamentoService;
    }

    @Override
    public Estacionamento executar(Estacionamento estacionamento) {

        if(estacionamento.isPeriodoFixo() && estacionamento.getTempo() == null) {
            throw new TempoPermanenciaNaoInformadoException();
        }

        if(estacionamento.getPagamento().getFormaPagamento().equals(FormaPagamentoEnum.PIX)) {
            throw new FormaPagamentoNaoHabilitadaParaPeriodosVariaveisException();
        }

        estacionamento.setDataCriacao(LocalDateTime.now());
        estacionamento.setStatus(StatusEnum.EM_PROGRESSO);
        return this.estacionamentoService.save(estacionamento);
    }
}
