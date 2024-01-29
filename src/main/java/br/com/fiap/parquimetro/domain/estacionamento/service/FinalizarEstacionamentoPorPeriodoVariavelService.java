package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.*;
import br.com.fiap.parquimetro.domain.estacionamento.exception.DadosInvalidosException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PagamentoNaoAprovadoException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PeriodoNaoEncontratoException;
import br.com.fiap.parquimetro.domain.estacionamento.repository.*;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;

import java.time.LocalDateTime;
import java.util.Optional;

public class FinalizarEstacionamentoPorPeriodoVariavelService implements FinalizarEstacionamentoPorPeriodo {

    private EstacionamentoService estacionamentoService;

    private RealizarPagamento realizarPagamento;

    private EmiteRecibo emiteRecibo;
    public FinalizarEstacionamentoPorPeriodoVariavelService(
            EstacionamentoService estacionamentoService,
            RealizarPagamento realizarPagamento,
            EmiteRecibo emiteRecibo){
        this.estacionamentoService = estacionamentoService;
        this.realizarPagamento = realizarPagamento;
        this.emiteRecibo = emiteRecibo;
    }

    @Override
    public Estacionamento executar(Estacionamento estacionamento) {

        if(!estacionamento.isQuitado()) {

            estacionamento.setDataFinalizacao(LocalDateTime.now());
            estacionamento.calculaValorPeriodoVariavel();

            Pagamento pagamentoSalvo = estacionamento.getPagamento();
            pagamentoSalvo.setStatusPagamento(StatusPagamentoEnum.PENDENTE);
            pagamentoSalvo.setValor(estacionamento.getValor().getValor());
            pagamentoSalvo.setDataPagamento(LocalDateTime.now());

            Boolean aprovacaoPagamento = this.realizarPagamento.execute(estacionamento);

            if(!aprovacaoPagamento) {
                throw new PagamentoNaoAprovadoException();
            }

            pagamentoSalvo.setStatusPagamento(StatusPagamentoEnum.QUITADO);
            estacionamento.setStatus(StatusEnum.ENCERRADO);

            Estacionamento estacionamentoSalvo = this.estacionamentoService.update(estacionamento);

            this.emiteRecibo.executar(estacionamento);

            return estacionamentoSalvo;
        }

        return estacionamento;

    }

}
