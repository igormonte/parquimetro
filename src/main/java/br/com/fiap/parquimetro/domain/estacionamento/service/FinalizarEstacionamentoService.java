package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.*;
import br.com.fiap.parquimetro.domain.estacionamento.exception.DadosInvalidosException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.DadosPagamentoNaoInformadosException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PagamentoNaoAprovadoException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PeriodoNaoEncontratoException;
import br.com.fiap.parquimetro.domain.estacionamento.repository.*;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

public class FinalizarEstacionamentoService implements FinalizarEstacionamento {

    private EstacionamentoService estacionamentoService;

    private RealizarPagamento realizarPagamento;

    private EmiteRecibo emiteRecibo;

    private HashMap<PeriodoEnum, FinalizarEstacionamentoPorPeriodo> servicos;

    public FinalizarEstacionamentoService(
            EstacionamentoService estacionamentoService,
            RealizarPagamento realizarPagamento,
            EmiteRecibo emiteRecibo){
        this.estacionamentoService = estacionamentoService;
        this.realizarPagamento = realizarPagamento;
        this.emiteRecibo = emiteRecibo;
        this.servicos = new HashMap<>(){{
            put(PeriodoEnum.FIXO, new FinalizarEstacionamentoPorPeriodoFixoService(
                    estacionamentoService));
            put(PeriodoEnum.VARIAVEL, new FinalizarEstacionamentoPorPeriodoVariavelService(
                    estacionamentoService, realizarPagamento, emiteRecibo));
        }};
    }

    @Override
    public Boolean executar(String uuid) {

        Optional<Estacionamento> estacionamento = this.estacionamentoService.findById(uuid);

        if(estacionamento.isEmpty()) {
            throw new DadosInvalidosException();
        }

        Estacionamento estacionamentoSalvo = estacionamento.get();

        FinalizarEstacionamentoPorPeriodo servico =
                this.getFinalizarEstacionamentoPorPeriodo(estacionamentoSalvo.getPeriodo());

        estacionamentoSalvo = servico.executar(estacionamentoSalvo);

        return estacionamentoSalvo.isEncerrado();

    }

    private FinalizarEstacionamentoPorPeriodo getFinalizarEstacionamentoPorPeriodo(PeriodoEnum periodo) {
        if(periodo == null || !this.servicos.containsKey(periodo)) {
            throw new PeriodoNaoEncontratoException();
        }
        return this.servicos.get(periodo);
    }



}
