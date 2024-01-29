package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamentoPorFormaPagamento;
import br.com.fiap.parquimetro.infraestructure.gateway.builder.PagadorBuilder;
import br.com.fiap.parquimetro.infraestructure.gateway.builder.RequestGeraCobrancaCreditoBuilder;
import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaCredito;
import br.com.fiap.parquimetro.infraestructure.gateway.model.Pagador;
import br.com.fiap.parquimetro.infraestructure.gateway.service.GatewayBancoService;

public class RealizarPagamentoPorCreditoService implements RealizarPagamentoPorFormaPagamento {

    private GatewayBancoService gatewayBancoService;

    public RealizarPagamentoPorCreditoService(GatewayBancoService gatewayBancoService) {
        this.gatewayBancoService = gatewayBancoService;
    }

    @Override
    public Boolean execute(Estacionamento estacionamento) {
        Pagamento pagamento = estacionamento.getPagamento();
        Condutor condutor = estacionamento.getCondutor();

        RequestGeraCobrancaCredito geraCobranca =
                new RequestGeraCobrancaCreditoBuilder()
                    .withSeuNumero(pagamento.getUuid())
                    .withLocalDate(pagamento.getDataCriacao().toLocalDate())
                    .withBigDecimal(pagamento.getValor())
                    .withPagador(
                        new PagadorBuilder()
                            .withCpfPagador(condutor.getCpf())
                            .withNumeroCartao(pagamento.getCartao().getNumeroCartao())
                            .withNomeTitular(pagamento.getCartao().getNomeTitular())
                            .withCvv(pagamento.getCartao().getCvv())
                            .build()
                    )
                    .build();

        return this.gatewayBancoService.geraCobrancaCredito(geraCobranca);
    }
}
