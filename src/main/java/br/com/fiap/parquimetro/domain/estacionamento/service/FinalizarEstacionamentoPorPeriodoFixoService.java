package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.*;
import br.com.fiap.parquimetro.domain.estacionamento.exception.DadosInvalidosException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PagamentoNaoAprovadoException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PeriodoNaoEncontratoException;
import br.com.fiap.parquimetro.domain.estacionamento.repository.FinalizarEstacionamentoPorPeriodo;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamentoPorPeriodo;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;

import java.time.LocalDateTime;
import java.util.Optional;

public class FinalizarEstacionamentoPorPeriodoFixoService implements FinalizarEstacionamentoPorPeriodo {

    private EstacionamentoService estacionamentoService;

    public FinalizarEstacionamentoPorPeriodoFixoService(
            EstacionamentoService estacionamentoService){
        this.estacionamentoService = estacionamentoService;
    }

    @Override
    public Estacionamento executar(Estacionamento estacionamento) {
        estacionamento.setStatus(StatusEnum.ENCERRADO);
        return this.estacionamentoService.update(estacionamento);

    }

}
