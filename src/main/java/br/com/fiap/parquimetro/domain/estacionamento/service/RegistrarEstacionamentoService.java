package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.exception.DadosInvalidosException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.DadosPagamentoNaoInformadosException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.PeriodoNaoEncontratoException;
import br.com.fiap.parquimetro.domain.estacionamento.repository.EmiteRecibo;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamentoPorPeriodo;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class RegistrarEstacionamentoService implements RegistrarEstacionamento {

    private EstacionamentoService estacionamentoService;

    private RealizarPagamento realizarPagamento;

    private EmiteRecibo emiteRecibo;

    private HashMap<PeriodoEnum, RegistrarEstacionamentoPorPeriodo> servicos;

    public RegistrarEstacionamentoService(EstacionamentoService estacionamentoService,
                                          RealizarPagamento realizarPagamento,
                                          EmiteRecibo emiteRecibo){
        this.estacionamentoService = estacionamentoService;
        this.realizarPagamento = realizarPagamento;
        this.emiteRecibo = emiteRecibo;
        this.servicos = new HashMap<>(){{
            put(PeriodoEnum.FIXO, new RegistrarEstacionamentoPorPeriodoFixoService(
                    estacionamentoService, realizarPagamento, emiteRecibo));
            put(PeriodoEnum.VARIAVEL, new RegistrarEstacionamentoPorPeriodoVariavelService(
                    estacionamentoService));
        }};
    }

    @Override
    public Estacionamento executar(Estacionamento estacionamento) {

        log.info(estacionamento.toString());

        if(estacionamento == null) {
            throw new DadosInvalidosException();
        }

        if(estacionamento.getPagamento() == null) {
            throw new DadosPagamentoNaoInformadosException();
        }

        RegistrarEstacionamentoPorPeriodo servico =
                this.getRegistrarEstacionamentoPorPeriodo(estacionamento.getPeriodo());

        estacionamento.setStatus(StatusEnum.AGUARDANDO_PAGAMENTO);
        return servico.executar(estacionamento);

    }

    private RegistrarEstacionamentoPorPeriodo getRegistrarEstacionamentoPorPeriodo(PeriodoEnum periodo) {

        if(periodo == null || !this.servicos.containsKey(periodo)) {
            throw new PeriodoNaoEncontratoException();
        }

        return this.servicos.get(periodo);
    }



}
