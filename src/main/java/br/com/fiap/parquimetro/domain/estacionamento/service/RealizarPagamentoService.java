package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.exception.FormaDePagametoNaoEncontradaException;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamentoPorFormaPagamento;
import br.com.fiap.parquimetro.infraestructure.gateway.service.GatewayBancoService;
import br.com.fiap.parquimetro.infraestructure.pix.service.PixService;

import java.util.HashMap;

public class RealizarPagamentoService implements RealizarPagamento {

    private PixService pixService;
    private GatewayBancoService gatewayBancoService;

    public RealizarPagamentoService(PixService pixService,
                            GatewayBancoService gatewayBancoService) {
        this.pixService = pixService;
        this.gatewayBancoService = gatewayBancoService;
        this.servicos = new HashMap<>(){{
            put(FormaPagamentoEnum.PIX, new RealizarPagamentoPorPixService(pixService));
            put(FormaPagamentoEnum.CARTAO_DEBITO, new RealizarPagamentoPorDebitoService(gatewayBancoService));
            put(FormaPagamentoEnum.CARTAO_CREDITO, new RealizarPagamentoPorCreditoService(gatewayBancoService));
        }};
    }

    private HashMap<FormaPagamentoEnum, RealizarPagamentoPorFormaPagamento> servicos;

    @Override
    public Boolean execute(Estacionamento estacionamento) {
        Pagamento pagamento = estacionamento.getPagamento();
        RealizarPagamentoPorFormaPagamento servico =
                this.getRealizarPagamentoPorFormaPagamento(pagamento.getFormaPagamento());
        return servico.execute(estacionamento);
    }

    private RealizarPagamentoPorFormaPagamento getRealizarPagamentoPorFormaPagamento(FormaPagamentoEnum formaPagamento) {
        if(formaPagamento == null || !this.servicos.containsKey(formaPagamento)) {
            throw new FormaDePagametoNaoEncontradaException();

        }

        return this.servicos.get(formaPagamento);

    }

}
