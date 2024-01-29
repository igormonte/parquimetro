package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RealizarPagamentoPorFormaPagamento;
import br.com.fiap.parquimetro.infraestructure.gateway.builder.PagadorBuilder;
import br.com.fiap.parquimetro.infraestructure.pix.builder.RequestGeraCobrancaPixBuilder;
import br.com.fiap.parquimetro.infraestructure.pix.dto.RequestGeraCobrancaPix;
import br.com.fiap.parquimetro.infraestructure.pix.service.PixService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class RealizarPagamentoPorPixService implements RealizarPagamentoPorFormaPagamento {

    private PixService pixService;

    public RealizarPagamentoPorPixService(PixService pixService) {
        this.pixService = pixService;
    }

    @Override
    public Boolean execute(Estacionamento estacionamento) {
        Pagamento pagamento = estacionamento.getPagamento();

        RequestGeraCobrancaPix geraCobranca =
                new RequestGeraCobrancaPixBuilder()
                        .withSeuNumero(pagamento.getUuid())
                        .withLocalDate(pagamento.getDataCriacao().toLocalDate())
                        .withBigDecimal(pagamento.getValor())
                        .build();

        String pix = this.pixService.geraCobrancaPix(geraCobranca);

        log.info(String.format("PIX GERADO: %s", pix));

        return pix != null;
    }
}
