package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.exception.*;
import br.com.fiap.parquimetro.domain.estacionamento.repository.EmiteRecibo;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamentoPorPeriodo;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
public class RegistrarEstacionamentoPorPeriodoFixoService implements RegistrarEstacionamentoPorPeriodo {

    private EstacionamentoService estacionamentoService;

    private RealizarPagamento realizarPagamento;

    private EmiteRecibo emiteRecibo;

    public RegistrarEstacionamentoPorPeriodoFixoService(
            EstacionamentoService estacionamentoService,
            RealizarPagamento realizarPagamento,
            EmiteRecibo emiteRecibo){
        this.estacionamentoService = estacionamentoService;
        this.realizarPagamento = realizarPagamento;
        this.emiteRecibo = emiteRecibo;
    }

    @Override
    public Estacionamento executar(Estacionamento estacionamento) {

        if(estacionamento.isPeriodoFixo() && estacionamento.getTempo() == null) {
            throw new TempoPermanenciaNaoInformadoException();
        }

        estacionamento.setDataCriacao(LocalDateTime.now());
        estacionamento.calculaDataPreviaSaida();
        estacionamento.calculaValorPeriodoFixo();
        estacionamento.setStatus(StatusEnum.AGUARDANDO_PAGAMENTO);

        Pagamento pagamento = estacionamento.getPagamento();
        pagamento.setStatusPagamento(StatusPagamentoEnum.PENDENTE);
        pagamento.setValor(estacionamento.getValor().getValor());
        Estacionamento estacionamentoSalvo = this.estacionamentoService.save(estacionamento);

        if(estacionamentoSalvo == null) {
           throw new EstacionamentoNaoCriadoException();
        }

        Boolean aprovacaoPagamento = this.realizarPagamento.execute(estacionamentoSalvo);

        if(!aprovacaoPagamento) {
            throw new PagamentoNaoAprovadoException();
        }

        Pagamento pagamentoSalvo = estacionamentoSalvo.getPagamento();
        pagamentoSalvo.setDataPagamento(LocalDateTime.now());
        pagamentoSalvo.setStatusPagamento(StatusPagamentoEnum.QUITADO);

        estacionamentoSalvo.setStatus(StatusEnum.EM_PROGRESSO);
        estacionamentoSalvo = this.estacionamentoService.update(estacionamentoSalvo);
        
        this.emiteRecibo.executar(estacionamentoSalvo);

        return estacionamentoSalvo;

    }
}
